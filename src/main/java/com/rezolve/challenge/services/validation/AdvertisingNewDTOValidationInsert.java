package com.rezolve.challenge.services.validation;

import com.rezolve.challenge.dto.AdvertisingNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class AdvertisingNewDTOValidationInsert implements ConstraintValidator<AdvertisingNewDtoInsert, AdvertisingNewDTO> {

    @Override
    public void initialize(AdvertisingNewDtoInsert constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(AdvertisingNewDTO value, ConstraintValidatorContext context) {
        return this.isHrefWithValidUrlFormat(value)
                && this.validateUrlIsHttpStatusOk(value)
                && !value.getGeofenceList().isEmpty();
    }

    /**
     * Validate if URL is valid, without need to call the URL.
     *
     * @param advertisingNewDTO
     */
    private Boolean isHrefWithValidUrlFormat(final AdvertisingNewDTO advertisingNewDTO) {
        log.info("Checking URL {} format.", advertisingNewDTO.getHref());
        final UrlValidator urlValidator = new UrlValidator();
        final boolean urlValid = urlValidator.isValid(advertisingNewDTO.getHref());
        log.info("URL {} format is {}", advertisingNewDTO.getHref(), urlValid ? "VALID" : "INVALID");
        return urlValid;
    }

    /**
     * Validate if URL will return HTTP status 200 {@link org.springframework.http.HttpStatus.OK}.
     *
     * @param advertisingNewDTO
     * @return
     */
    private Boolean validateUrlIsHttpStatusOk(final AdvertisingNewDTO advertisingNewDTO) {
        try {
            log.info("Checking URL {} connection...", advertisingNewDTO.getHref());
            final URL url = new URL(advertisingNewDTO.getHref());
            final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            log.info("URL response Code is: {}", urlConnection.getResponseCode());
            return urlConnection.getResponseCode() == HttpStatus.OK.value();
        } catch (final IOException e) {
            log.error("URL {} got error : ", advertisingNewDTO.getHref(), e);
        }
        return Boolean.FALSE;
    }

}
