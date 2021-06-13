package com.rezolve.challenge.resources.interfaces;

import com.rezolve.challenge.dto.GeofenceDTO;
import com.rezolve.challenge.dto.GeofenceNewDTO;
import com.rezolve.challenge.dto.InsertedDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GeofenceResource {

    public ResponseEntity<?> getbyId(@PathVariable final Integer id);

    public ResponseEntity<InsertedDTO> createGeofence(@RequestBody final GeofenceNewDTO geofenceNewDTO, final Errors errors);

    public ResponseEntity<List<GeofenceDTO>> findAll();

}
