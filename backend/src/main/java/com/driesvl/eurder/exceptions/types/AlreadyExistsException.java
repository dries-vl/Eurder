package com.driesvl.eurder.exceptions.types;

import com.driesvl.eurder.exceptions.LoggingException;

public class AlreadyExistsException extends LoggingException {
    public AlreadyExistsException(String nameOfSourceClass, String message) {
        super(nameOfSourceClass, message);
    }
}
