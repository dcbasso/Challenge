package com.rezolve.challenge.services;

import com.rezolve.challenge.dto.GeofenceNewDTO;
import com.rezolve.challenge.model.Geofence;
import com.rezolve.challenge.respository.GeofenceRepository;
import com.rezolve.challenge.services.exceptions.ObjectNotFoundException;
import com.rezolve.challenge.services.interfaces.GeofenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Optional;

@Service
public class GeofenceServiceImpl implements GeofenceService {

    @Autowired
    private GeofenceRepository geofenceRepository;

    @Transactional
    @Override
    public Geofence create(final Geofence geofence) {
        return this.geofenceRepository.save(geofence);
    }

    @Override
    public Geofence findById(final Integer id) {
        final Optional<Geofence> optionalGeofence = this.geofenceRepository.findById(id);
        return optionalGeofence.orElseThrow(() -> new ObjectNotFoundException(String.format("Object of %s with ID %d not located.", Geofence.class.getName(), id)));
    }

    @Override
    public List<Geofence> findAll() {
        return this.geofenceRepository.findAll();
    }

    @Override
    public Geofence fromGeofenceNewDTO(final GeofenceNewDTO geofenceNewDTO) {
        return Geofence.builder()
                .radius(geofenceNewDTO.getRadius())
                .latitude(geofenceNewDTO.getLatitude())
                .longitude(geofenceNewDTO.getLongitude()).build();
    }

}
