package com.guakun22.robot.wali.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ServiceException{

    public ResourceNotFoundException(String message) {
        super(message);
        setStatusCode(HttpStatus.NOT_FOUND);
        setErrorCode("RESOURCE_NOT_FOUND");
        setErrorType(ServiceErrorTypeEnum.Client);
    }

}
