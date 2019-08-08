package com.objectfrontier.training.java.jdbc.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.java.jdbc.exception.AppException;
import com.objectfrontier.training.java.jdbc.model.Address;
import com.objectfrontier.training.java.jdbc.service.AddressService;
import com.objectfrontier.training.java.jdbc.service.ConnectionManager;

public class AddressServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        Connection conn = null;

        PrintWriter out = res.getWriter();

        try {
            // Establishing connection to connect the servlet with database
            conn = ConnectionManager.getConnection();
            AddressService addressService = new AddressService();

            if ("/address/read".equalsIgnoreCase(req.getServletPath())) {
                // Getting the id of an address as parameter via URL
                String idParameter = req.getParameter("id");
                Long id = Long.parseLong(idParameter);

                // Read an address corresponding to the given id
                Address retrivedAddress = addressService.read(conn, id);

                // Print the address from the corresponding id given via URL
                out.write(JsonConverter.toJson(retrivedAddress));
                ConnectionManager.releaseConnection(conn, true);
            } else if ("/address/readAll".equals(req.getServletPath())) {
                // Read all addresses from the database
                List<Address> retrived = addressService.readAll(conn);

                // Print all the address from the database
                for (Address address : retrived) {
                    out.write(JsonConverter.toJson(address));
                }
                ConnectionManager.releaseConnection(conn, true);
            }
        } catch (Exception e) {
            ConnectionManager.releaseConnection(conn, false);
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                out.write(JsonConverter.toJson(((AppException) e).getErrorList()));
            }
        }
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        Connection conn = null;

        PrintWriter out = res.getWriter();

        try {
            // Establishing connection to connect the servlet with database
            conn = ConnectionManager.getConnection();
            AddressService addressService = new AddressService();

            Address input = toObject(req.getReader());
            Address address = addressService.create(conn, input);
            out.write(JsonConverter.toJson(address));
            ConnectionManager.releaseConnection(conn, true);
        } catch (Exception e) {

            ConnectionManager.releaseConnection(conn, false);
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                out.write(JsonConverter.toJson(((AppException) e).getErrorList()));
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        Connection conn = null;

        PrintWriter out = res.getWriter();

        try {
            // Establishing connection to connect the servlet with database
            conn = ConnectionManager.getConnection();
            AddressService addressService = new AddressService();

            if ("/address/update".equalsIgnoreCase(req.getServletPath())) {

                Address input = toObject(req.getReader());
                Address address = addressService.update(conn, input);
                out.write(JsonConverter.toJson(address));
                ConnectionManager.releaseConnection(conn, true);
            } else if ("/address/delete".equalsIgnoreCase(req.getServletPath())) {

                Address input = toObject(req.getReader());
                Address address = addressService.delete(conn, input);
                out.write(JsonConverter.toJson(address));
                ConnectionManager.releaseConnection(conn, true);
            }
        } catch (Exception e) {
            ConnectionManager.releaseConnection(conn, false);
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                out.write(JsonConverter.toJson(((AppException) e).getErrorList()));
            }
        }
    }

    private Address toObject(BufferedReader reader) {

        List<String> jsonLines = reader.lines().collect(Collectors.toList()); //or use readLine() Method with while block
        String addressJson = String.join("", jsonLines); //or use readLine() Method with while block

        //Converting JSON to Object
        Address input = JsonConverter.toObject(addressJson, Address.class);
        return input;
    }
}
