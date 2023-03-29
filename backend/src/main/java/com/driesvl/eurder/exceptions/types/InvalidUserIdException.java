package com.driesvl.eurder.exceptions.types;

import com.driesvl.eurder.exceptions.LoggingException;

public class InvalidUserIdException extends LoggingException {
    public InvalidUserIdException(String nameOfSourceClass, String message) {
        super(nameOfSourceClass, message);
    }
}
