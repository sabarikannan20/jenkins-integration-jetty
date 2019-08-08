package com.objectfrontier.training.java.jdbc.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.objectfrontier.training.java.jdbc.exception.AppException;
import com.objectfrontier.training.java.jdbc.exception.ExceptionCode;


public class ConnectionManager {

    private static Connection connection = null;

//    static HikariConfig config = new HikariConfig("/resources/db.properties");
//    static { config.setMaximumPoolSize(3); }
//    static HikariDataSource ds = new HikariDataSource(config);

    public static Connection getConnection() throws SQLException, IOException {

//       connection =  ds.getConnection();
       connection = DriverManager.getConnection("jdbc:mysql://rpc65:3306/arunkumar?useSSL=true", "arun", "demo");
       connection.setAutoCommit(false);

        if (connection != null) {
            log("%s", "Connected!\n");
            return connection;
        } else {
            log("%s", "Not Connected!");
            return null;
        }
    }

    public static void releaseConnection(Connection con, boolean isSuccess) {

        try {
            if (isSuccess) {
                con.commit();
                con.close();
            } else {
                con.rollback();
                con.close();
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            throw new AppException(ExceptionCode.INTERNAL_SERVER_ERROR);
        }
    }

    private static void log(String format, String vals) {
        System.out.format(format, vals);
    }
}
