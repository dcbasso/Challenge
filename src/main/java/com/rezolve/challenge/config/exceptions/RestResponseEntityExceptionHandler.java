package com.rezolve.challenge.config.exceptions;

import com.rezolve.challenge.model.exception.ApiError;
import com.rezolve.challenge.services.exceptions.ObjectNotFoundException;
import com.rezolve.challenge.services.exceptions.ValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> genericError(final Exception exception, final WebRequest request) {
        final ApiError apiError = ApiError.builder()
                .message("Internal server error. Please contact support.")
                .build();
        return handleExceptionInternal(exception, apiError, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { ObjectNotFoundException.class })
    protected ResponseEntity<Object> handleObjectNotFoundException(final ObjectNotFoundException exception, final WebRequest request) {
        final ApiError apiError = exception.getApiError() != null ? exception.getApiError() : ApiError.builder()
                .message(exception.getMessage())
                .build();
        return handleExceptionInternal(exception, apiError, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { ValidationException.class })
    protected ResponseEntity<Object> validationException(final ValidationException exception, final WebRequest request) {
        final ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .build();
        return handleExceptionInternal(exception, apiError, new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

}