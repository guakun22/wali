package com.guakun22.robot.wali.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {

    private String code;
    private ServiceErrorTypeEnum type;
    private String message;
    private HttpStatus httpStatusCode;
}
