package com.driesvl.eurder.exceptions.api;

import com.driesvl.eurder.exceptions.types.CustomerAlreadyExistsException;
import com.driesvl.eurder.exceptions.types.InvalidUserIdException;
import com.driesvl.eurder.exceptions.types.UnauthorizedException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandlers {
    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public void badRequest(CustomerAlreadyExistsException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(InvalidUserIdException.class)
    public void badId(InvalidUserIdException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.I_AM_A_TEAPOT.value(), exception.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public void unauthorized(UnauthorizedException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }
}
