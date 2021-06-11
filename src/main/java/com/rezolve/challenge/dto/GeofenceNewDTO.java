package com.rezolve.challenge.dto;

import com.rezolve.challenge.services.validation.GeofenceNewDtoInsert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@GeofenceNewDtoInsert
public class GeofenceNewDTO implements Serializable {

    private Double latitude;

    private Double longitude;

    private Integer radius;

}
