package com.objectfrontier.training.java.jdbc.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.objectfrontier.training.java.jdbc.model.Address;
import com.objectfrontier.training.java.jdbc.model.Person;

public class CSVReader {

    /* Getting input CSV file to give details to create person */

    public Object[][] fileParse() throws IOException, URISyntaxException {

        Path filePath = Paths.get(ClassLoader.getSystemResource("csv\\service.person.csv").toURI());
//        Path filePath = Paths.get("D:\\dev\\training\\subramania.ravi\\service\\resources\\csv\\service.person.csv");
        Stream<String> inputFile = Files.lines(filePath);
        List<String[]> myFile = inputFile.map(input -> input.split(",")).collect(Collectors.toList());
        inputFile.close();
        List<Person> createdFile = new ArrayList<>();

        for (String[] input : myFile) {
            Address createdAddress = new Address(input[4], input[5], Integer.valueOf(input[6]));
            createdFile.add(new Person(input[0], input[1], input[2], input[3], Timestamp.from(Instant.now()), createdAddress));
        }

        List<Person> expectedFile = createdFile;
        Object[][] givenPerson = new Object[createdFile.size()][2];

        for (int i = 0; i < createdFile.size(); i++) {
            givenPerson[i][0] = createdFile.get(i);
            givenPerson[i][1] = expectedFile.get(i);
        }

        return givenPerson;
    }
}
