package com.self.education.catinfo.handler;

import com.self.education.catinfo.exception.ErrorMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(value = BAD_REQUEST)
    public ErrorMessage handleIllegalArgumentException(final IllegalArgumentException ex, final WebRequest request) {
        //@formatter:off
        return new ErrorMessage(
                BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        //@formatter:on
    }

    @ExceptionHandler
    @ResponseStatus(value = BAD_REQUEST)
    public ErrorMessage handleValidationError(final MethodArgumentNotValidException ex, final WebRequest request) {
        //@formatter:off
        return new ErrorMessage(
                BAD_REQUEST.value(),
                ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).sorted().collect(Collectors.joining(", ")),
                request.getDescription(false)
        );
        //@formatter:on
    }

    @ExceptionHandler
    @ResponseStatus(value = BAD_REQUEST)
    public ErrorMessage handleConstraintViolationException(final ConstraintViolationException ex, final WebRequest request) {
        //@formatter:off
        return new ErrorMessage(
                BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        //@formatter:on
    }

    @ExceptionHandler
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    public ErrorMessage handleGlobalException(final Exception ex, final WebRequest request) {
        //@formatter:off
        return new ErrorMessage(
                INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false)
        );
        //@formatter:on
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus(value = CONFLICT)
    public ErrorMessage handleDataIntegrityViolation(final DataIntegrityViolationException ex, final WebRequest request) {
        //@formatter:off
        return new ErrorMessage(
                CONFLICT.value(),
                ex.getCause().getMessage(),
                request.getDescription(false)
        );
        //@formatter:on
    }
}