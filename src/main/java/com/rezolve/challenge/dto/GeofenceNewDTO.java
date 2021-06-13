package com.rezolve.challenge.dto;

import com.rezolve.challenge.services.validation.GeofenceNewDtoInsert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@GeofenceNewDtoInsert
public class GeofenceNewDTO implements Serializable {

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotNull
    private Double radius;

}
