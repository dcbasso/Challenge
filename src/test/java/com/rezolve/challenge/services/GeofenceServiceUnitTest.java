package com.rezolve.challenge.services;

import com.rezolve.challenge.model.Geofence;
import com.rezolve.challenge.respository.GeofenceRepository;
import com.rezolve.challenge.services.exceptions.ObjectNotFoundException;
import com.rezolve.challenge.services.interfaces.GeofenceService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeofenceServiceUnitTest {

    @MockBean
    private GeofenceRepository geofenceRepository;

    @Autowired
    private GeofenceService geofenceService;

    @Test
    public void findGeogenceByIdShouldReturnSuccess() {
        final Integer id = 1;
        final Geofence geofence = Geofence.builder()
                .id(id)
                .radius(2.00)
                .latitude(7.1234567)
                .longitude(1.7654321)
                .build();
        Mockito.when(this.geofenceRepository.findById(id)).thenReturn(Optional.of(geofence));
        final Geofence objFound = this.geofenceService.findById(id);
        Assert.assertNotNull(objFound);
    }

    @Test
    public void findGeogenceByIdShouldReturnNull() {
        final Integer id = 1;
        Mockito.when(this.geofenceRepository.findById(id)).thenReturn(Optional.ofNullable(null));
        Assert.assertThrows(ObjectNotFoundException.class, () -> this.geofenceService.findById(id));
    }

    @Test
    public void insertOneGeofenceCheckRepositoryIsSavingObject() {
        final Integer id = 1;
        final Geofence geofence = Geofence.builder()
                .id(id)
                .radius(2.00)
                .latitude(7.1234567)
                .longitude(1.7654321)
                .build();
        this.geofenceService.create(geofence);
        Mockito.verify(this.geofenceRepository, times(1)).save(Mockito.any());
    }

    @Test
    public void findGeogenceByIdShouldReturnListSuccess() {
        final Integer id = 1;
        final Geofence geofence = Geofence.builder()
                .id(id)
                .radius(2.00)
                .latitude(7.1234567)
                .longitude(1.7654321)
                .build();

        Mockito.when(this.geofenceRepository.findAll()).thenReturn(Arrays.asList(geofence));

        final List<Geofence> all = this.geofenceService.findAll();
        Assert.assertNotNull(all);
        Assert.assertEquals(1, all.size());
    }


}
