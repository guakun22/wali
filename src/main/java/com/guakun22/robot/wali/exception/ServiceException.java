package com.guakun22.robot.wali.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServiceException extends RuntimeException {

    private HttpStatus statusCode;
    private String errorCode; // biz error code
    private ServiceErrorTypeEnum errorType;

    public ServiceException(String message) {
        super(message);
    }
    
}
