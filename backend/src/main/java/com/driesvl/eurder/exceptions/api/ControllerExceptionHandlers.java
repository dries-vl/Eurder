package com.driesvl.eurder.exceptions.api;

import com.driesvl.eurder.exceptions.types.AlreadyExistsException;
import com.driesvl.eurder.exceptions.types.IdAlreadyTakenException;
import com.driesvl.eurder.exceptions.types.InvalidUserIdException;
import com.driesvl.eurder.exceptions.types.UnauthorizedException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandlers {
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException e) {
        return e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
    }

    @ExceptionHandler(IdAlreadyTakenException.class)
    public void somehowIdenticalId(IdAlreadyTakenException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.I_AM_A_TEAPOT.value(), exception.getMessage() + " SHOULD NEVER HAPPEN");
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public void badRequest(AlreadyExistsException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.ALREADY_REPORTED.value(), exception.getMessage());
    }

    @ExceptionHandler(InvalidUserIdException.class)
    public void badId(InvalidUserIdException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public void unauthorized(UnauthorizedException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
    }
}
