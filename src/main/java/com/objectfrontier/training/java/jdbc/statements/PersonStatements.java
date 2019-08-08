package com.objectfrontier.training.java.jdbc.statements;

public interface PersonStatements {

    String CREATE_QUERY = new StringBuilder()
            .append("INSERT INTO service_person (first_name    ")
            .append("                          , last_name     ")
            .append("                          , email         ")
            .append("                          , address_id    ")
            .append("                          , birth_date    ")
            .append("                          , created_date) ")
            .append("VALUES (?, ?, ?, ?, ?, ?)                 ")
            .toString();

    String READ_QUERY = new StringBuilder()
            .append("SELECT first_name   ")
            .append("     , last_name    ")
            .append("     , email        ")
            .append("     , address_id   ")
            .append("     , birth_date   ")
            .append("     , created_date ")
            .append("FROM service_person ")
            .append("WHERE id = ?        ")
            .toString();

    String READ_ALL_QUERY = new StringBuilder()
            .append("SELECT id           ")
            .append("     , first_name   ")
            .append("     , last_name    ")
            .append("     , email        ")
            .append("     , address_id   ")
            .append("     , birth_date   ")
            .append("     , created_date ")
            .append("FROM service_person ")
            .toString();

    String GET_ADDRESS_ID = new StringBuilder()
            .append("SELECT address_id   ")
            .append("FROM service_person ")
            .append("WHERE id = ?        ")
            .toString();

    String UPDATE_QUERY = new StringBuilder()
            .append("UPDATE service_person ")
            .append("SET first_name = ?,   ")
            .append("last_name = ?,        ")
            .append("email = ?,            ")
            .append("address_id = ?,       ")
            .append("birth_date = ?        ")
            .append("WHERE id = ?          ")
            .toString();

    String DELETE_QUERY = new StringBuilder()
            .append("DELETE              ")
            .append("FROM service_person ")
            .append("WHERE id = ?        ")
            .toString();
}
