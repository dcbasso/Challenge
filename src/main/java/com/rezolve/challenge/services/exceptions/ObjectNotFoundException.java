package com.rezolve.challenge.services.exceptions;

import com.rezolve.challenge.model.exception.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

    private ApiError apiError;

    public ObjectNotFoundException(final String msg) {
        super(msg);
    }

    public ObjectNotFoundException(final String msg, final ApiError apiError) {
        super(msg);
        this.apiError = apiError;
    }

    public ApiError getApiError() {
        return apiError;
    }
}
