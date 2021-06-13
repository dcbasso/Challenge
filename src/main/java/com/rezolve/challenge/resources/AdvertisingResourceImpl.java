package com.rezolve.challenge.resources;

import com.rezolve.challenge.dto.AdvertisingDTO;
import com.rezolve.challenge.dto.AdvertisingNewDTO;
import com.rezolve.challenge.dto.InsertedDTO;
import com.rezolve.challenge.model.Advertising;
import com.rezolve.challenge.resources.interfaces.AdvertisingResource;
import com.rezolve.challenge.services.exceptions.ValidationException;
import com.rezolve.challenge.services.interfaces.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/advertising")
public class AdvertisingResourceImpl implements AdvertisingResource {

    @Autowired
    private AdvertisingService advertisingService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @Override
    public ResponseEntity<?> getbyId(@PathVariable final Integer id) {
        final Advertising advertising = this.advertisingService.findById(id);
        return ResponseEntity.ok().body(advertising);
    }

    @RequestMapping(method = RequestMethod.GET)

    @Override
    public ResponseEntity<List<AdvertisingDTO>> findAll() {
        final List<Advertising> advertisingList = this.advertisingService.findAll();
        final List<AdvertisingDTO> advertisingDTOList = advertisingList.stream().map(AdvertisingDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(advertisingDTOList);
    }

    @RequestMapping(method = RequestMethod.POST)
    @Override
    public ResponseEntity<InsertedDTO> create(@RequestBody @Valid final AdvertisingNewDTO advertisingNewDTO, final Errors errors) {
        if (errors.getErrorCount() > 0) {
            throw  new ValidationException("Invalid Advertising data or missing information");
        }
        final Advertising advertising = this.advertisingService.create(this.advertisingService.fromAdvertisingNewDTO(advertisingNewDTO));
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(advertising.getId()).toUri();
        return ResponseEntity.created(uri).body(new InsertedDTO(advertising.getId()));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @Override
    public ResponseEntity<Void> update(@RequestBody @Valid final AdvertisingNewDTO advertisingNewDTO, @PathVariable final Integer id) {
        final Advertising advertising = this.advertisingService.fromAdvertisingNewDTO(advertisingNewDTO);
        advertising.setId(id);
        this.advertisingService.update(advertising);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        this.advertisingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
