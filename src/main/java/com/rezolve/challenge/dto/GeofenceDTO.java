package com.rezolve.challenge.dto;

import com.rezolve.challenge.model.Geofence;
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
public class GeofenceDTO implements Serializable {

    private Integer id;

    private Double latitude;

    private Double longitude;

    private Double radius;

    public GeofenceDTO(final Geofence geofence) {
        this.id = geofence.getId();
        this.latitude = geofence.getLatitude();
        this.longitude = geofence.getLongitude();
        this.radius = geofence.getRadius();
    }

}
