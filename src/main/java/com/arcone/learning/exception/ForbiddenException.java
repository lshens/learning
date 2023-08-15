package com.arcone.learning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@ResponseStatus(FORBIDDEN)
public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        super("The username or password is invalid");
    }
}
