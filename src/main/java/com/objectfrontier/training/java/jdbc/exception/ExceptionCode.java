package com.objectfrontier.training.java.jdbc.exception;

public enum ExceptionCode {

    FIRST_NAME_EMPTY(101, "First name should not be empty"),
    LAST_NAME_EMPTY(102, "Last name should not be empty"),
    EMAIL_EMPTY(103, "Email address should not be empty"),
    BIRTH_DATE_EMPTY(104, "Birth date should not be empty"),
    CREATED_DATE_EMPTY(105, "Created date should not be empty"),
    INVALID_DATE_FORMAT(106, "Invalid date format. Please use dd/MM/yyyy format"),
    EMAIL_ADDRESS_DUPLICATE(107, "Duplicate Email address entry. The email address you have mentioned already exists"),
    ID_AUTOINCREMENT(108, "Id should be auto-incremented"),
    SAME_FIRST_NAME_LAST_NAME(109, "First name and last name should not be same"),
    ID_NOT_FOUND(110, "No entry found in the given ID"),
    STREET_NAME_EMPTY(111, "Street name should not be empty"),
    CITY_NAME_EMPTY(112, "City name should not be empty"),
    POSTAL_CODE_EMPTY(113, "Postal code should not be empty"),
    CREATION_ERROR(114, "Error occured due to invalid input"),
    INTERNAL_SERVER_ERROR(115, "Internal server error");

    private final int errorCode;
    private final String errorMsg;

    ExceptionCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMsg = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMsg;
    }
}
