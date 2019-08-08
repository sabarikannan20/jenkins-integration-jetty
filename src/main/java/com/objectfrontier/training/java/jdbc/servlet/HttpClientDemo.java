package com.objectfrontier.training.java.jdbc.servlet;

import com.objectfrontier.training.java.jdbc.model.Address;

/**
 * @author prassie
 * @since  Oct 03, 2006
 */
public class HttpClientDemo {

    private void run(String[] args) throws Exception {

        String url = "http://localhost:8080/web.app";
        Address givenAddress = new Address("Taramani", "Chennai", 600016);
//        Address expectedAddress = givenAddress;
        RequestHelper.setBaseUrl(url);
        RequestHelper helper = new RequestHelper();
        Address createdAddress = helper.setMethod(HttpMethod.PUT)
                .setInput(givenAddress)
                .setSecured(false)
                .requestObject("/address/create", Address.class);
        log(createdAddress.toString());
//        log(RequestHelper.init().requestString(url));
    }

    public static void main(String[] args) {
        try {
            new HttpClientDemo().run(args);
        } catch (Exception e) {
            log(e);
        }
    }

    private static void log(Object o) {
        if (o instanceof Throwable) {
            ((Throwable)o).printStackTrace(System.err);
        } else {
            System.out.println(o);
        }
    }
}
