package com.ayupovmi.pmapp.exception;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }
}
