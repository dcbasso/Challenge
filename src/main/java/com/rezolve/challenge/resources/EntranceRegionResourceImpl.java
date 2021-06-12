package com.rezolve.challenge.resources;

import com.rezolve.challenge.dto.AdvertisingDTO;
import com.rezolve.challenge.dto.EntranceRegionDTO;
import com.rezolve.challenge.model.Advertising;
import com.rezolve.challenge.resources.interfaces.EntranceRegionResource;
import com.rezolve.challenge.services.interfaces.EntranceRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/entrance")
public class EntranceRegionResourceImpl implements EntranceRegionResource {

    @Autowired
    private EntranceRegionService entranceRegionService;

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public ResponseEntity<List<AdvertisingDTO>> entranceRegion(@RequestBody @Valid final EntranceRegionDTO entranceRegionDTO) {
        final List<Advertising> advertisingList = entranceRegionService.advertisingExists(entranceRegionDTO);
        final List<AdvertisingDTO> advertisingDTOList = advertisingList.stream().map(AdvertisingDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(advertisingDTOList);
    }

}
