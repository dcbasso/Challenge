package com.rezolve.challenge.resources.interfaces;

import com.rezolve.challenge.dto.AdvertisingDTO;
import com.rezolve.challenge.dto.EntranceRegionDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EntranceRegionResource {

    public ResponseEntity<List<AdvertisingDTO>> entranceRegion(final EntranceRegionDTO entranceRegionDTO);

}
