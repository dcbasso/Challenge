package com.rezolve.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeofenceNewDTO implements Serializable {

    private Double latitude;

    private Double longitude;

    private Integer radius;

}
