package com.driesvl.eurder.exceptions.types;

import com.driesvl.eurder.exceptions.LoggingException;

public class IdAlreadyTakenException extends LoggingException {
    public IdAlreadyTakenException(String nameOfSourceClass, String message) {
        super(nameOfSourceClass, message);
    }
}
