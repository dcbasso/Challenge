package com.rezolve.challenge.services;

import com.rezolve.challenge.dto.AdvertisingNewDTO;
import com.rezolve.challenge.model.Advertising;
import com.rezolve.challenge.respository.AdvertisingRepository;
import com.rezolve.challenge.services.exceptions.ObjectNotFoundException;
import com.rezolve.challenge.services.interfaces.AdvertisingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private AdvertisingRepository advertisingRepository;

    @Override
    public Advertising create(final Advertising advertising) {
        return this.advertisingRepository.save(advertising);
    }

    @Override
    public Advertising findById(final Integer id) {
        final Optional<Advertising> optionalAdvertising = this.advertisingRepository.findById(id);
        return optionalAdvertising.orElseThrow(() -> new ObjectNotFoundException(String.format("Object of %s with ID %d not located.", Advertising.class.getName(), id)));
    }

    @Override
    public List<Advertising> findAll() {
        return this.advertisingRepository.findAll();
    }

    @Override
    public void delete(final Integer id) {
        this.findById(id);
        this.advertisingRepository.deleteById(id);
    }

    @Override
    public void update(final Advertising advertising) {
        this.findById(advertising.getId());
        this.advertisingRepository.save(advertising);
    }

    @Override
    public Advertising fromAdvertisingNewDTO(final AdvertisingNewDTO advertisingNewDTO) {
        return Advertising.builder()
                .href(advertisingNewDTO.getHref())
                .geofenceList(advertisingNewDTO.getGeofenceList())
                .build();
    }

}
