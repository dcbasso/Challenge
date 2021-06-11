package com.rezolve.challenge.dto;

import com.rezolve.challenge.model.Advertising;
import com.rezolve.challenge.model.Geofence;
import com.rezolve.challenge.services.validation.AdvertisingNewDtoInsert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@AdvertisingNewDtoInsert
public class AdvertisingDTO implements Serializable {

    private Integer id;

    private String href;

    private List<Geofence> geofenceList;

    public AdvertisingDTO(final Advertising advertising) {
        this.id = advertising.getId();
        this.href = advertising.getHref();
        this.geofenceList = advertising.getGeofenceList();
    }

}
