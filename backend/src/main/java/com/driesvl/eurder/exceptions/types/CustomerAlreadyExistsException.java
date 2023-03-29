package com.driesvl.eurder.exceptions.types;

import com.driesvl.eurder.exceptions.LoggingException;

public class CustomerAlreadyExistsException extends LoggingException {
    public CustomerAlreadyExistsException(String nameOfSourceClass, String message) {
        super(nameOfSourceClass, message);
    }
}
