package com.objectfrontier.training.java.jdbc.test;

import java.io.IOException;
import java.sql.Connection;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.objectfrontier.training.java.jdbc.model.Address;
import com.objectfrontier.training.java.jdbc.service.AddressService;
import com.objectfrontier.training.java.jdbc.servlet.HttpMethod;
import com.objectfrontier.training.java.jdbc.servlet.JsonConverter;
import com.objectfrontier.training.java.jdbc.servlet.RequestHelper;

public class AddressServletTest {

    private AddressService addressService;
    String baseUrl = "http://localhost:8080/web.app/address";
    private Connection connection = null;

    private static final String INPUTS_MSG = "INPUTS: given = %s, expected = %s.";
    private static final String ASSERT_FAIL_MSG = "Expected:<%s> but was:<%s>";

    /* Before Test */

    @BeforeTest
    private void init() throws IOException {

        try {
            this.addressService = new AddressService();
            RequestHelper.setBaseUrl(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Positive testcase for create Address */

    @Test(dataProvider = "testCreatePositive", enabled = false)
    private void testCreate_positive(Address givenAddress, Address expectedAddress) {

        try {
            Address createdAddress = new RequestHelper().setMethod(HttpMethod.PUT)
                                                        .setInput(givenAddress)
                                                        .setSecured(false)
                                                        .requestObject("/create", Address.class);
            Assert.assertEquals(JsonConverter.toJson(createdAddress), JsonConverter.toJson(expectedAddress), "Success!");
        } catch (Exception e) {
            Assert.fail(String.format(ASSERT_FAIL_MSG, givenAddress.getId(), e.getMessage()));
        }
    }

    /* Dataprovider for positive testcase for create Address */

    @DataProvider(name = "testCreatePositive")
    private Object[][] testCreatePositiveValues() {

        Address givenAddressOne = new Address("Allikuttai", "Salem", 636003);
        Address expectedAddressOne = givenAddressOne;
        expectedAddressOne.setId(38);
        return new Object[][] {
                                { givenAddressOne, expectedAddressOne }
        };
    }

    /* Negative testcase for create Address */
//
//    @Test(dataProvider = "testCreateNegative", enabled = false)
//    private void testCreate_negative(Address givenAddress, List<ExceptionCode> expectedError) {
//
//        try {
//            Address createdAddress = new RequestHelper().setMethod(HttpMethod.PUT)
//                                                        .setInput(givenAddress)
//                                                        .setSecured(false)
//                                                        .requestObject("/create", Address.class);
//            Assert.fail("Address creation failed!");
//        } catch (Exception e) {
//            if (e instanceof AppException) {
//                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Address creation failed!");
//            }
//        }
//    }
//
//    /* Dataprovider for negative testcase for create Address */
//
//    @DataProvider(name = "testCreateNegative")
//    private Object[][] testCreateNegativeValues() {
//
//        Address givenAddress1 = new Address("", "", 636003);
//        Address givenAddress2 = new Address("Ammapet", "", 636003);
//        Address givenAddress3 = new Address("Ammapet", "Salem", 0);
//        List<ExceptionCode> errorListOne = new ArrayList<>();
//        List<ExceptionCode> errorListTwo = new ArrayList<>();
//        List<ExceptionCode> errorListThree = new ArrayList<>();
//        errorListOne.add(ExceptionCode.STREET_NAME_EMPTY);
//        errorListOne.add(ExceptionCode.CITY_NAME_EMPTY);
//        errorListTwo.add(ExceptionCode.CITY_NAME_EMPTY);
//        errorListThree.add(ExceptionCode.POSTAL_CODE_EMPTY);
//        return new Object[][] {
//                                { givenAddress1, errorListOne },
//                                { givenAddress2, errorListTwo },
//                                { givenAddress3, errorListThree }
//        };
//    }
//
//    /* Positive testcase for update Address */
//
//    @Test(dataProvider = "testUpdatePositive", enabled = true)
//    private void testUpdate_positive(Address givenAddress, Address expectedAddress) {
//
//        try {
//            Address updatedAddress = new RequestHelper().setMethod(HttpMethod.POST)
//                                                        .setInput(givenAddress)
//                                                        .setSecured(false)
//                                                        .requestObject("/update", Address.class);
//            Assert.assertEquals(updatedAddress.toString(), expectedAddress.toString(), "Success!");
//        } catch (Exception e) {
//            Assert.fail(String.format(ASSERT_FAIL_MSG, givenAddress.getId(), expectedAddress.getId(), e.getMessage()));
//        }
//    }
//
//    /* Dataprovider for positive testcase for update Address */
//
//    @DataProvider(name = "testUpdatePositive")
//    private Object[][] testUpdatePositiveValues() {
//
//        Address givenAddressOne = new Address(26, "Peelamedu", "Coimbatore", 641004);
//        Address expectedAddressOne = givenAddressOne;
//        return new Object[][] {
//                                { givenAddressOne, expectedAddressOne }
//        };
//    }
//
//    /* Negative testcase for update Address */
//
//    @Test(dataProvider = "testUpdateNegative", enabled = false)
//    private void testUpdate_negative(Address givenAddress, List<ExceptionCode> expectedError) {
//
//        try {
//            Address updatedAddress = new RequestHelper().setMethod(HttpMethod.POST)
//                                                        .setInput(givenAddress)
//                                                        .setSecured(false)
//                                                        .requestObject("/update", Address.class);
//            Assert.fail("Address updation failed!");
//        } catch (Exception e) {
//            if (e instanceof AppException) {
//                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Address updation failed!");
//            }
//        }
//    }
//
//    /* Dataprovider for negative testcase for update Address */
//
//    @DataProvider(name = "testUpdateNegative")
//    private Object[][] testUpdateNegativeValues() {
//
//        Address givenAddress1 = new Address(4, "Ammapet", "Salem", 636003);
//        Address givenAddress2 = new Address(33, "", "Salem", 0);
//        Address givenAddress3 = new Address(33, "Ammapet", "", 0);
//        Address givenAddress4 = new Address(33, "Ammapet", "Salem", 0);
//        List<ExceptionCode> errorListOne = new ArrayList<>();
//        List<ExceptionCode> errorListTwo = new ArrayList<>();
//        List<ExceptionCode> errorListThree = new ArrayList<>();
//        List<ExceptionCode> errorListFour = new ArrayList<>();
//        errorListOne.add(ExceptionCode.ID_NOT_FOUND);
//        errorListTwo.add(ExceptionCode.STREET_NAME_EMPTY);
//        errorListThree.add(ExceptionCode.CITY_NAME_EMPTY);
//        errorListFour.add(ExceptionCode.POSTAL_CODE_EMPTY);
//        return new Object[][] {
//                                { givenAddress1, errorListOne },
//                                { givenAddress2, errorListTwo },
//                                { givenAddress3, errorListThree },
//                                { givenAddress4, errorListFour }
//        };
//    }
//
//    /* Positive testcase for read Address */
//
//    @Test(dataProvider = "testReadPositive", enabled = false)
//    private void testRead_positive(long addressId, Address expectedAddress) {
//
//        try {
//            String retrivedAddress = new RequestHelper().setMethod(HttpMethod.GET)
//                                                        .setSecured(false)
//                                                        .requestString("/read?id=" + addressId);
//            Address address = JsonConverter.toObject(retrivedAddress, Address.class);
//            Assert.assertEquals(address.getId(), expectedAddress.getId(), "Success!");
//        } catch (Exception e) {
//            Assert.fail(e.getMessage());
//        }
//    }
//
//    /* Dataprovider for positive testcase for read Address */
//
//    @DataProvider(name = "testReadPositive")
//    private Object[][] testReadPositiveValues() {
//
//        long addressId = 10;
//        Address expectedAddress = new Address();
//        expectedAddress.setId(addressId);
//        return new Object[][] {
//                                { addressId, expectedAddress }
//        };
//    }
//
//    /* Negative testcase for read Address */
//
//    @Test(dataProvider = "testReadNegative", enabled = false)
//    private void testRead_negative(long addressId, List<ExceptionCode> expectedError) {
//
//        try {
//            String retrivedAddress = new RequestHelper().setMethod(HttpMethod.GET)
//                                                        .setSecured(false)
//                                                        .requestString("/read?id=" + addressId);
//            Assert.fail("Address Read failed!");
//        } catch (Exception e) {
//            if (e instanceof AppException) {
//                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Address read failed!");
//            }
//        }
//    }
//
//    /* Dataprovider for negative testcase for read Address */
//
//    @DataProvider(name = "testReadNegative")
//    private Object[][] testReadNegativeValues() {
//
//        long addressId = 5;
//        List<ExceptionCode> errorList = new ArrayList<>();
//        errorList.add(ExceptionCode.ID_NOT_FOUND);
//        return new Object[][] {
//                                { addressId, errorList }
//        };
//    }
//
//    /* Positive testcase for delete Address */
//
//    @Test(dataProvider = "testDeletePositive", enabled = false)
//    private void testDelete_positive(Address givenAddress) {
//
//        try {
//            Address deletedAddress = new RequestHelper().setMethod(HttpMethod.POST)
//                                                        .setInput(givenAddress)
//                                                        .setSecured(false)
//                                                        .requestObject("/delete", Address.class);
//            Assert.assertEquals(deletedAddress.getId(), givenAddress.getId(), "Success!");
//        } catch (Exception e) {
//            Assert.fail(e.getMessage());
//        }
//    }
//
//    /* Dataprovider for positive testcase for delete Address */
//
//    @DataProvider(name = "testDeletePositive")
//    private Object[][] testDelete_positive() {
//
//        Address givenAddress = new Address(19);
//        return new Object[][] {
//                                { givenAddress }
//        };
//    }
//
//    /* Negative testcase for delete Address */
//
//    @Test(dataProvider = "testDeleteNegative", enabled = false)
//    private void testDelete_negative(Address address, List<ExceptionCode> expectedError) throws SQLException, IOException {
//
//        try {
//            Address deletedAddress = new RequestHelper().setMethod(HttpMethod.POST)
//                                                        .setInput(address)
//                                                        .setSecured(false)
//                                                        .requestObject("/delete", Address.class);
//            Assert.fail("Address deletion failed!");
//        } catch (Exception e) {
//            if (e instanceof AppException) {
//                Assert.assertEquals(((AppException) e).getErrorList(), expectedError, "Success!");
//            }
//        }
//    }
//
//    /* Dataprovider for negative testcase for delete Address */
//
//    @DataProvider(name = "testDeleteNegative")
//    private Object[][] testDelete_negative() throws SQLException, IOException {
//
//        Address givenAddress = new Address(18);
//        List<ExceptionCode> errorList = new ArrayList<>();
//        errorList.add(ExceptionCode.ID_NOT_FOUND);
//        return new Object[][] {
//                                { givenAddress, errorList }
//        };
//    }
//
//    /* Search Address */
//
//    @Test(priority = 4, enabled = false)
//    private void testSearch() throws SQLException {
//
//        try {
//            String[] columnName = new String[] {"street" , "city", "postalCode"};
//            addressService.search(connection, "salem", columnName);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
