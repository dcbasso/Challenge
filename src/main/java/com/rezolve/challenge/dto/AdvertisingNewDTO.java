package com.rezolve.challenge.dto;

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
public class AdvertisingNewDTO implements Serializable {

    private String href;

    private List<Geofence> geofenceList;

}
