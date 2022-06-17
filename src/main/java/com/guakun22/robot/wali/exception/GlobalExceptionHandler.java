package com.guakun22.robot.wali.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    ResponseEntity<ErrorResponse> handleServiceException(ServiceException exception) {

        return ResponseEntity
                .status(exception.getStatusCode())
                .body(
                        ErrorResponse
                                .builder()
                                .code(exception.getErrorCode())
                                .message(exception.getMessage())
                                .httpStatusCode(exception.getStatusCode())
                                .type(exception.getErrorType())
                                .build())
                ;
    }
}
