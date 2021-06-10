package com.rezolve.challenge.resources;

import com.rezolve.challenge.model.Geofence;
import com.rezolve.challenge.dto.GeofenceDTO;
import com.rezolve.challenge.dto.GeofenceNewDTO;
import com.rezolve.challenge.dto.InsertedDTO;
import com.rezolve.challenge.resources.interfaces.GeofenceResource;
import com.rezolve.challenge.services.GeofenceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/geofence")
public class GeofenceResourceImpl implements GeofenceResource {

    @Autowired
    private GeofenceServiceImpl geofenceService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @Override
    public ResponseEntity<?> getbyId(@PathVariable final Integer id) {
        final Geofence geofence = this.geofenceService.findById(id);
        return ResponseEntity.ok().body(geofence);
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public ResponseEntity<InsertedDTO> createGeofence(@RequestBody final GeofenceNewDTO geofenceNewDTO) {
        final Geofence newGeofence = this.geofenceService.create(this.geofenceService.fromGeofenceNewDTO(geofenceNewDTO));
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newGeofence.getId()).toUri();
        return ResponseEntity.created(uri).body(new InsertedDTO(newGeofence.getId()));
    }

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<GeofenceDTO>> findAll() {
        final List<Geofence> geofenceList = this.geofenceService.findAll();
        final List<GeofenceDTO> geofenceDTOList = geofenceList.stream().map(geofence -> new GeofenceDTO(geofence)).collect(Collectors.toList());
        return ResponseEntity.ok().body(geofenceDTOList);
    }


}
