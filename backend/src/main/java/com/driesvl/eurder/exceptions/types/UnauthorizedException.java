package com.driesvl.eurder.exceptions.types;

import com.driesvl.eurder.exceptions.LoggingException;

public class UnauthorizedException extends LoggingException {
    public UnauthorizedException(String nameOfSourceClass, String message) {
        super(nameOfSourceClass, message);
    }
}
