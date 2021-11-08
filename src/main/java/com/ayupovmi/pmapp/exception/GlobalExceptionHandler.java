package com.ayupovmi.pmapp.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //handle specific exceptions
    @ExceptionHandler(ApiException.class)
public ResponseEntity<Object> handleAPIException
(ApiException exception, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(),
            exception.getMessage(), request.getDescription(false));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    //handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourseNotFoundException
    (ResourceNotFoundException exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }
    //MethodArgumentNotValidException
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
    //HttpRequestMethodNotSupportedException
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorDetails);

    }
    //UserNameNotFoundException
    @ExceptionHandler(UserNameNotFoundException.class)
    public final ResponseEntity <Object> handleUserNameNotFoundException (UserNameNotFoundException
                                                                                  exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    //handle global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException
    (Exception exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

}
