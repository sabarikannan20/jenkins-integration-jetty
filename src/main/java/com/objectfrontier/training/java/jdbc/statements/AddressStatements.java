package com.objectfrontier.training.java.jdbc.statements;

public interface AddressStatements {

    String CREATE_QUERY = new StringBuilder()
            .append("INSERT INTO service_address (street       ")
            .append("                           , city         ")
            .append("                           , postal_code) ")
            .append("VALUES (?, ?, ?)                          ")
            .toString();

    String READ_QUERY = new StringBuilder()
            .append("SELECT id            ")
            .append("     , street        ")
            .append("     , city          ")
            .append("     , postal_code   ")
            .append("FROM service_address ")
            .append("WHERE id = ?         ")
            .toString();

    String READ_ALL_QUERY = new StringBuilder()
            .append("SELECT id            ")
            .append("     , street        ")
            .append("     , city          ")
            .append("     , postal_code   ")
            .append("FROM service_address ")
            .toString();

    String UPDATE_QUERY = new StringBuilder()
            .append("UPDATE service_address ")
            .append("SET street = ?,        ")
            .append("city = ?,              ")
            .append("postal_code = ?        ")
            .append("WHERE id = ?           ")
            .toString();

    String DELETE_QUERY = new StringBuilder()
            .append("DELETE               ")
            .append("FROM service_address ")
            .append("WHERE id = ?         ")
            .toString();

}
