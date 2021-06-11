package com.rezolve.challenge.resources.interfaces;

import com.rezolve.challenge.dto.AdvertisingDTO;
import com.rezolve.challenge.dto.AdvertisingNewDTO;
import com.rezolve.challenge.dto.InsertedDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdvertisingResource {

    public ResponseEntity<?> getbyId(final Integer id);

    public ResponseEntity<List<AdvertisingDTO>> findAll();

    public ResponseEntity<InsertedDTO> create(final AdvertisingNewDTO advertisingNewDTO);

    public ResponseEntity<Void> update(final AdvertisingNewDTO advertisingNewDTO, final Integer id);

    public ResponseEntity<Void> delete(final Integer id);

}
