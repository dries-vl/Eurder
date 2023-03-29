package com.driesvl.eurder.exceptions;

import com.driesvl.eurder.exceptions.types.IdAlreadyTakenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingException extends RuntimeException {
    public LoggingException(String nameOfSourceClass, String message) {
        super(nameOfSourceClass + ": " + message);
        logException(nameOfSourceClass + ": " + message);
    }

    private void logException(String logMessage) {
        Logger logger = LoggerFactory.getLogger(IdAlreadyTakenException.class);
        logger.warn(logMessage);
    }
}
