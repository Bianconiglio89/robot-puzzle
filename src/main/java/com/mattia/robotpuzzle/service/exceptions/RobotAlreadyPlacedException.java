package com.mattia.robotpuzzle.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RobotAlreadyPlacedException extends RuntimeException {

    public RobotAlreadyPlacedException(String message) {
        super(message);
    }
}
