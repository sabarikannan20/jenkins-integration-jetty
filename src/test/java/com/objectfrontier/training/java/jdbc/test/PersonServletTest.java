package com.objectfrontier.training.java.jdbc.test;

import java.io.IOException;
import java.sql.Connection;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.java.jdbc.model.Person;
import com.objectfrontier.training.java.jdbc.service.PersonService;
import com.objectfrontier.training.java.jdbc.servlet.HttpMethod;
import com.objectfrontier.training.java.jdbc.servlet.JsonConverter;
import com.objectfrontier.training.java.jdbc.servlet.RequestHelper;

public class PersonServletTest {

    private PersonService personService;
    String baseUrl = "http://localhost:8080/web.app/person";
    private Connection connection = null;

    /* Before Test */

    @BeforeTest
    private void init() throws IOException {

        try {
            this.personService = new PersonService();
            RequestHelper.setBaseUrl(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Positive testcase for create Person */
//
//    @Test(dataProvider = "testCreatePositive", enabled = true)
//    private void testCreatePositive(Person givenPerson, Person expectedPerson) {
//
//        try {
//            Person createdPerson = new RequestHelper().setMethod(HttpMethod.PUT)
//                                                      .setInput(givenPerson)
//                                                      .setSecured(false)
//                                                      .requestObject("/create", Person.class);
//            System.out.println(createdPerson.toString());
//            Assert.assertEquals(createdPerson.getId(), expectedPerson.getId(), "Success!");
//        } catch (Exception e) {
////            Assert.fail(e.getMessage());
//            if(e instanceof AppException) {
//                System.out.println(((AppException) e).getErrorList());
//            }
//        }
//    }
//
//    /* Dataprovider for positive testcase for create Person */
//
//    @DataProvider(name = "testCreatePositive")
//    private Object[][] testCreate_positiveValues() {
//
//        Address givenAddress = new Address("Thoraipakkam", "Chennai", 600097);
//        Person givenPerson = new Person("Kathi", "D", "udhayan@gmail.com", "15-12-1996", Timestamp.from(Instant.now()), givenAddress);
//        Person expectedPerson = givenPerson;
//        expectedPerson.setId(8);
//        return new Object[][] {
//            { givenPerson, expectedPerson }
//        };
//    }

    /* Negative testcase for create Person */
//
//    @Test(dataProvider = "testCreateNegative", enabled = true)
//    private void testCreate_negative(Person givenPerson, List<ExceptionCode> expectedError) throws SQLException, IOException {
//
//        try {
//            Person createdPerson = new RequestHelper().setMethod(HttpMethod.PUT)
//                                                      .setInput(givenPerson)
//                                                      .setSecured(false)
//                                                      .requestObject("/create", Person.class);
//            Assert.fail("Person Creation failed!");
//        } catch (Exception e) {
//            if (e instanceof AppException) {
//                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Person creation failed!");
//            }
//        }
//    }
//
//    /* Dataprovider for negative testcase for create Person */
//
//    @DataProvider(name = "testCreateNegative")
//    private Object[][] testCreateNegativeValues() {
//
//        Address givenAddress1 = new Address("", "Chennai", 600096);
//        Address givenAddress2 = new Address("Thuraipakkam", "", 600096);
//        Address givenAddress3 = new Address("Thuraipakkam", "Chennai", 0);
//        Address givenAddress4 = new Address("Thuraipakkam", "Chennai", 600096);
//        Person givenPerson1 = new Person("Arun", "Kumar", "arunalaasal@gmail.com", "2-10-1996", Timestamp.from(Instant.now()), givenAddress1);
//        Person givenPerson2 = new Person("Arun", "Kumar", "arunalaasal@gmail.com", "3-10-1996", Timestamp.from(Instant.now()), givenAddress2);
//        Person givenPerson3 = new Person("Arun", "Kumar", "arunalaasal@gmail.com", "4-10-1996", Timestamp.from(Instant.now()), givenAddress3);
//        Person givenPerson4 = new Person(" ", "kumar", "arunalaasal@gmail.com", "5-10-1996", Timestamp.from(Instant.now()), givenAddress4);
//        Person givenPerson5 = new Person("Arun", "", "arunalaasal@gmail.com", "6-10-1996", Timestamp.from(Instant.now()), givenAddress4);
//        Person givenPerson6 = new Person("Arun", "Kumar", "", "7-10-1996", Timestamp.from(Instant.now()), givenAddress4);
//        Person givenPerson7 = new Person("Arun", "Kumar", "arunalaasal@gmail.com", "", Timestamp.from(Instant.now()), givenAddress4);
//        Person givenPerson8 = new Person("", "", "arun@gmail.com", "8-10-1996", Timestamp.from(Instant.now()), givenAddress4);
//        Person givenPerson9 = new Person("Arun", "Arun", "arunalaasal@gmail.com", "9-10-1996", Timestamp.from(Instant.now()), givenAddress4);
//        Person givenPerson10 = new Person("Arun", "Kumar", "arunalaasal@gmail.com", "10-10-1996", null, givenAddress4);
//        Person givenPerson11 = new Person("Arun", "Kumar", "arunalaasal@gmail.com", "1996-10-22", Timestamp.from(Instant.now()), givenAddress4);
//        List<ExceptionCode> errorList1 = new ArrayList<>();
//        List<ExceptionCode> errorList2 = new ArrayList<>();
//        List<ExceptionCode> errorList3 = new ArrayList<>();
//        List<ExceptionCode> errorList4 = new ArrayList<>();
//        List<ExceptionCode> errorList5 = new ArrayList<>();
//        List<ExceptionCode> errorList6 = new ArrayList<>();
//        List<ExceptionCode> errorList7 = new ArrayList<>();
//        List<ExceptionCode> errorList8 = new ArrayList<>();
//        List<ExceptionCode> errorList9 = new ArrayList<>();
//        List<ExceptionCode> errorList10 = new ArrayList<>();
//        errorList1.add(ExceptionCode.STREET_NAME_EMPTY);
//        errorList2.add(ExceptionCode.CITY_NAME_EMPTY);
//        errorList3.add(ExceptionCode.POSTAL_CODE_EMPTY);
//        errorList4.add(ExceptionCode.FIRST_NAME_EMPTY);
//        errorList5.add(ExceptionCode.LAST_NAME_EMPTY);
//        errorList6.add(ExceptionCode.EMAIL_EMPTY);
//        errorList7.add(ExceptionCode.INVALID_DATE_FORMAT);
//        errorList8.add(ExceptionCode.SAME_FIRST_NAME_LAST_NAME);
//        errorList8.add(ExceptionCode.FIRST_NAME_EMPTY);
//        errorList8.add(ExceptionCode.LAST_NAME_EMPTY);
//        errorList8.add(ExceptionCode.EMAIL_ADDRESS_DUPLICATE);
//        errorList9.add(ExceptionCode.SAME_FIRST_NAME_LAST_NAME);
//        errorList10.add(ExceptionCode.CREATED_DATE_EMPTY);
//        return new Object[][] {
//                                { givenPerson1, errorList1 },
//                                { givenPerson2, errorList2 },
//                                { givenPerson3, errorList3 },
//                                { givenPerson4, errorList4 },
//                                { givenPerson5, errorList5 },
//                                { givenPerson6, errorList6 },
//                                { givenPerson7, errorList7 },
//                                { givenPerson8, errorList8 },
//                                { givenPerson9, errorList9 },
//                                { givenPerson10, errorList10 },
//                                { givenPerson11, errorList7 }
//        };
//    }
//
//    /* Positive testcase for update Person */
//
//    @Test(dataProvider = "testUpdatePositive", enabled = false)
//    private void testUpdate_positive(Person givenPerson, Person expectedPerson) {
//
//        try {
//            Person updatedAddress = new RequestHelper().setMethod(HttpMethod.POST)
//                                                       .setInput(givenPerson)
//                                                       .setSecured(false)
//                                                       .requestObject("/update", Person.class);
//            Assert.assertEquals(updatedAddress.getEmail(), expectedPerson.getEmail(), "Success!");
//        } catch (Exception e) {
//            Assert.fail(e.getMessage());
//        }
//    }
//
//    /* Dataprovider for positive testcase for update Person */
//
//    @DataProvider(name = "testUpdatePositive")
//    private Object[][] testUpdatePositiveValues() {
//
//        Address givenAddress = new Address("Elampillai", "Salem", 636101);
//        Person givenPerson = new Person(1, "Praveen", "Kumar", "praveen@gmail.com", "15-08-1996", givenAddress);
//        Person expectedPerson = givenPerson;
//        return new Object[][] {
//                                { givenPerson, expectedPerson }
//        };
//    }
//
//    /* Negative testcase for update Person */
//
//    @Test(dataProvider = "testUpdateNegative", enabled = true)
//    private void testUpdate_negative(Person givenPerson, List<ExceptionCode> expectedError) throws SQLException, IOException {
//
//        try {
//            Person updatedAddress = new RequestHelper().setMethod(HttpMethod.POST)
//                                                       .setInput(givenPerson)
//                                                       .setSecured(false)
//                                                       .requestObject("/update", Person.class);
//            Assert.fail("Person updation failed!");
//        } catch (Exception e) {
//            if (e instanceof AppException) {
//                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Person updation failed!");
//            }
//        }
//    }
//
//    /* Dataprovider for negative testcase for update Person */
//
//    @DataProvider(name = "testUpdateNegative")
//    private Object[][] testUpdateNegativeValues() {
//
//        Address givenAddress1 = new Address("Ammapet", "Salem", 636003);
//        Address givenAddress2 = new Address("", "Salem", 0);
//        Address givenAddress3 = new Address("Ammapet", "", 0);
//        Address givenAddress4 = new Address("Ammapet", "Salem", 0);
//        Person givenPerson1 = new Person(5, "Sriram", "Narayanan", "siva@gmail.com", "15-08-1996", givenAddress1);
//        Person givenPerson2 = new Person(2, "Sriram", "Narayanan", "siva@gmail.com", "15-08-1996", givenAddress2);
//        Person givenPerson3 = new Person(2, "Sriram", "Narayanan", "siva@gmail.com", "15-08-1996", givenAddress3);
//        Person givenPerson4 = new Person(2, "Sriram", "Narayanan", "siva@gmail.com", "15-08-1996", givenAddress4);
//        Person givenPerson5 = new Person(2, "", "Narayanan", "siva@gmail.com", "15-08-1996", givenAddress1);
//        Person givenPerson6 = new Person(2, "Sriram", "", "siva@gmail.com", "15-08-1996", givenAddress1);
//        Person givenPerson7 = new Person(2, "Sriram", "Narayanan", "", "15-08-1996", givenAddress1);
//        Person givenPerson8 = new Person(2, "Sriram", "Narayanan", "siva@gmail.com", "", givenAddress1);
//        Person givenPerson9 = new Person(2, "Sriram", "Narayanan", "siva@gmail.com", "1996-08-16", givenAddress1);
//        Person givenPerson10 = new Person(2, "Sriram", "Narayanan", "vijay@gmail.com", "15-08-1996", givenAddress1);
//        Person givenPerson11 = new Person(2, "Praveen", "Praveen", "siva4@gmail.com", "12-06-2000", givenAddress1);
//        List<ExceptionCode> errorList1 = new ArrayList<>();
//        List<ExceptionCode> errorList2 = new ArrayList<>();
//        List<ExceptionCode> errorList3 = new ArrayList<>();
//        List<ExceptionCode> errorList4 = new ArrayList<>();
//        List<ExceptionCode> errorList5 = new ArrayList<>();
//        List<ExceptionCode> errorList6 = new ArrayList<>();
//        List<ExceptionCode> errorList7 = new ArrayList<>();
//        List<ExceptionCode> errorList8 = new ArrayList<>();
//        List<ExceptionCode> errorList9 = new ArrayList<>();
//        List<ExceptionCode> errorList10 = new ArrayList<>();
//        errorList1.add(ExceptionCode.ID_NOT_FOUND);
//        errorList2.add(ExceptionCode.STREET_NAME_EMPTY);
//        errorList2.add(ExceptionCode.POSTAL_CODE_EMPTY);
//        errorList3.add(ExceptionCode.CITY_NAME_EMPTY);
//        errorList3.add(ExceptionCode.POSTAL_CODE_EMPTY);
//        errorList4.add(ExceptionCode.POSTAL_CODE_EMPTY);
//        errorList5.add(ExceptionCode.FIRST_NAME_EMPTY);
//        errorList6.add(ExceptionCode.LAST_NAME_EMPTY);
//        errorList7.add(ExceptionCode.EMAIL_EMPTY);
//        errorList8.add(ExceptionCode.INVALID_DATE_FORMAT);
//        errorList9.add(ExceptionCode.EMAIL_ADDRESS_DUPLICATE);
//        errorList10.add(ExceptionCode.SAME_FIRST_NAME_LAST_NAME);
//        return new Object[][] {
//                                { givenPerson1, errorList1 },
//                                { givenPerson2, errorList2 },
//                                { givenPerson3, errorList3 },
//                                { givenPerson4, errorList4 },
//                                { givenPerson5, errorList5 },
//                                { givenPerson6, errorList6 },
//                                { givenPerson7, errorList7 },
//                                { givenPerson8, errorList8 },
//                                { givenPerson9, errorList8 },
//                                { givenPerson10, errorList9 },
//                                { givenPerson11, errorList10 }
//        };
//    }
//
//    /* Positive testcase for read Person */

    @Test(dataProvider = "testReadPositive", enabled = true)
    private void testRead_positive(long personId, Person expectedPerson) {

        try {
            String retrivedPerson = new RequestHelper().setMethod(HttpMethod.GET)
                                                       .setSecured(false)
                                                       .requestString("/read?id=" + personId + "&address=true");
            Person person = JsonConverter.toObject(retrivedPerson, Person.class);
            Assert.assertEquals(person.getId(), expectedPerson.getId(), "Success!");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    /* Dataprovider for positive testcase for read Person */

    @DataProvider(name = "testReadPositive")
    private Object[][] testReadPositiveValues() {

        long personId = 1;
        Person expectedPerson = new Person();
        expectedPerson.setId(personId);
        return new Object[][] {
                                { personId, expectedPerson }
        };
    }

//    /* Negative testcase for read Person */
//
//    @Test(dataProvider = "testReadNegative", enabled = true)
//    private void testRead_negative(long personId, List<ExceptionCode> expectedError) throws SQLException, IOException {
//
//        try {
//            String retrivedPerson = new RequestHelper().setMethod(HttpMethod.GET)
//                                                       .setSecured(false)
//                                                       .requestString("/read?id=" + personId + "&address=false");
//            Assert.fail(String.format("Person read failed!"));
//        } catch (Exception e) {
//            if (e instanceof AppException) {
//                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Person read failed!");
//            }
//        }
//    }
//
//    /* Dataprovider for negative testcase for read Person */
//
//    @DataProvider(name = "testReadNegative")
//    private Object[][] testReadNegativeValues() {
//
//        long personId = 330;
//        List<ExceptionCode> errorList = new ArrayList<>();
//        errorList.add(ExceptionCode.ID_NOT_FOUND);
//        return new Object[][] {
//                                { personId, errorList }
//        };
//    }
//
//    /* Positive testcase for delete Person */
//
//    @Test(dataProvider = "testDeletePositive", enabled = false)
//    private void testDelete_positive(Person givenPerson) {
//
//        try {
//            Person deletedPerson = new RequestHelper().setMethod(HttpMethod.POST)
//                                                      .setInput(givenPerson)
//                                                      .setSecured(false)
//                                                      .requestObject("/delete", Person.class);
//            Assert.assertEquals(deletedPerson.getId(), givenPerson.getId(), "Success!");
//        } catch (Exception e) {
//            Assert.fail(e.getMessage());
//        }
//    }
//
//    /* Dataprovider for positive testcase for delete Person */
//
//    @DataProvider(name = "testDeletePositive")
//    private Object[][] testDeletePositiveValues() {
//
//        Person givenPerson = new Person(6);
//        return new Object[][] {
//                                { givenPerson }
//        };
//    }
//
//    /* Negative testcase for delete Person */
//
//    @Test(dataProvider = "testDeleteNegative", enabled = true)
//    private void testDelete_negative(Person person, List<ExceptionCode> expectedError) throws SQLException, IOException {
//
//        try {
//            Person deletedPerson = new RequestHelper().setMethod(HttpMethod.POST)
//                                                      .setInput(person)
//                                                      .setSecured(false)
//                                                      .requestObject("/delete", Person.class);
//            Assert.fail("Person deletion failed!");
//        } catch (Exception e) {
//            if (e instanceof AppException) {
//                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Success!");
//            }
//        }
//    }
//
//    /* Dataprovider for positive testcase for delete Person */
//
//    @DataProvider(name = "testDeleteNegative")
//    private Object[][] testDeleteNegativeValues() {
//
//        Person givenPerson = new Person(15);
//        List<ExceptionCode> errorList = new ArrayList<>();
//        errorList.add(ExceptionCode.ID_NOT_FOUND);
//        return new Object[][] {
//                                { givenPerson, errorList }
//        };
//    }
}
