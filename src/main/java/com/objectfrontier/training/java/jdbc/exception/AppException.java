package com.objectfrontier.training.java.jdbc.exception;

import java.util.ArrayList;
import java.util.List;

public class AppException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

//    private int errorCode;
//    public String errorMsg;
    private List<ExceptionCode> errorList = new ArrayList<>();

//    public AppException(Exception e) {
//        super();
//    }

    public AppException(ExceptionCode code) {
//        this.errorCode = code.getErrorCode();
//        this.errorMsg = code.getErrorMessage();
        errorList.add(code);
    }

    public AppException(List<ExceptionCode> errorCodes) {
        super();
        this.errorList = errorCodes;
    }

    public List<ExceptionCode> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ExceptionCode> errorList) {
        this.errorList = errorList;
    }

//    public int getErrorCode() {
//        return errorCode;
//    }
//
//    public String getErrorMessage() {
//        return errorMsg;
//    }
}
