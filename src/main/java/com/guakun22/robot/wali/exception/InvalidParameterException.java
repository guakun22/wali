package com.guakun22.robot.wali.exception;

import org.springframework.http.HttpStatus;

public class InvalidParameterException extends ServiceException {

    public InvalidParameterException(String message) {
        super(message);
        setStatusCode(HttpStatus.BAD_REQUEST);
        setErrorCode("WRONG_QUERY");
        setErrorType(ServiceErrorTypeEnum.Client);
    }
}
