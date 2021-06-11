package com.rezolve.challenge.services.interfaces;

import com.rezolve.challenge.dto.AdvertisingNewDTO;
import com.rezolve.challenge.model.Advertising;

import java.util.List;

public interface AdvertisingService {

    public Advertising create(final Advertising advertising);

    public Advertising findById(final Integer id);

    public List<Advertising> findAll();

    public void delete(final Integer id);

    public void update(final Advertising advertising);

    Advertising fromAdvertisingNewDTO(final AdvertisingNewDTO advertisingNewDTO);
}
