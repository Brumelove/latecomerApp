package com.exquis.latecomerapp.domain.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

import static java.util.stream.Collectors.joining;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GenericExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeApiException.class)
    public ResponseEntity<ErrorResponse> handleCarApiException(EmployeeApiException employeeApiException){
        return new ResponseEntity<>(employeeApiException.getErrorResponse(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        log.error("Constraint Violation Exception ::: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorDescription(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ErrorResponse> handleConnectionTimedOutException(ResourceAccessException ex) {
        log.error("Resource Access Exception ::: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorDescription(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        log.error("DataIntegrity Violation Exception ::: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorDescription(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValid Exception ::: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorDescription("One or More required Fields is empty");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        String messageBuilder = ex.getContentType() + " media type is not supported. Supported media types are " +
                ex.getSupportedMediaTypes().stream().map(MediaType::getType).collect(joining(","));
        errorResponse.setErrorDescription(messageBuilder);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
