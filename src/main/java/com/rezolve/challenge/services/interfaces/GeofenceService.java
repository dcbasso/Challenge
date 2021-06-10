package com.rezolve.challenge.services.interfaces;

import com.rezolve.challenge.model.Geofence;
import com.rezolve.challenge.dto.GeofenceNewDTO;

import java.util.List;

public interface GeofenceService {

    public Geofence create(final Geofence geofence);

    public Geofence findById(final Integer id);

    public List<Geofence> findAll();

    public Geofence fromGeofenceNewDTO(final GeofenceNewDTO geofenceNewDTO);

}
