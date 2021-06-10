package com.rezolve.challenge.services.validation;

import com.rezolve.challenge.dto.GeofenceNewDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GeofenceNewDTOValidationInsert implements ConstraintValidator<GeofenceNewDtoInsert, GeofenceNewDTO> {

    @Override
    public void initialize(GeofenceNewDtoInsert constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(GeofenceNewDTO value, ConstraintValidatorContext context) {
        return value.getLatitude() != null && value.getLongitude() != null && value.getRadius() != null;
    }

}
