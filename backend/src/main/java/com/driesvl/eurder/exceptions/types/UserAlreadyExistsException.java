package com.driesvl.eurder.exceptions.types;

import com.driesvl.eurder.exceptions.LoggingException;

public class UserAlreadyExistsException extends LoggingException {
    public UserAlreadyExistsException(String nameOfSourceClass, String message) {
        super(nameOfSourceClass, message);
    }
}
