package com.rezolve.challenge.model.exception;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;

@Data
@Builder
public class ApiError {

    private String message;
    private HashMap<String, String> errors;

}
