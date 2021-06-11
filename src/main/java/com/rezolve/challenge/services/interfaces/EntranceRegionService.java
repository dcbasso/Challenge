package com.rezolve.challenge.services.interfaces;

import com.rezolve.challenge.dto.EntranceRegionDTO;
import com.rezolve.challenge.model.Advertising;

import java.util.List;

public interface EntranceRegionService {

    public List<Advertising> advertisingExists(final EntranceRegionDTO entranceRegionDTO);
}
