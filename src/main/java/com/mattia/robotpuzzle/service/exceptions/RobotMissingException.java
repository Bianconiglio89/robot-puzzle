package com.mattia.robotpuzzle.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Robot Missing")
public class RobotMissingException extends RuntimeException {

    public RobotMissingException(String message) {
        super(message);
    }

}
