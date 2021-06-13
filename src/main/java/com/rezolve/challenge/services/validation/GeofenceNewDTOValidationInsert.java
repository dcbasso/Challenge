package com.rezolve.challenge.services.validation;

import com.rezolve.challenge.dto.GeofenceNewDTO;
import com.rezolve.challenge.utils.Constants;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GeofenceNewDTOValidationInsert implements ConstraintValidator<GeofenceNewDtoInsert, GeofenceNewDTO> {

    @Override
    public void initialize(GeofenceNewDtoInsert constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(final GeofenceNewDTO value, ConstraintValidatorContext context) {
        return value.getLatitude() != null
                && value.getLongitude() != null
                && value.getRadius() != null
                && this.isLatitudeInRange(value.getLatitude())
                && this.isLongitudeInRange(value.getLongitude());
    }

    private Boolean isLatitudeInRange(final Double latitude) {
        return latitude != null ? latitude > Constants.LATITUDE_MIN && latitude < Constants.LATITUDE_MIN : Boolean.FALSE;
    }

    private Boolean isLongitudeInRange(final Double latitude) {
        return latitude != null ? latitude > Constants.LONGITUDE_MAX && latitude < Constants.LONGITUDE_MIN : Boolean.FALSE;
    }

}
