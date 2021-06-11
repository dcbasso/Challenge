package com.rezolve.challenge.integration;

import com.rezolve.challenge.model.Geofence;
import com.rezolve.challenge.respository.GeofenceRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class GeofenceRepositoryIntegrationTest {

    @Autowired
    private GeofenceRepository geofenceRepository;

    @Test
    public void saveOneGeoFence_thenFindOneWithFindAll() {
        final Geofence geofence = Geofence.builder()
                .latitude(10.80)
                .longitude(11.08)
                .radius(2.00)
                .build();

        geofenceRepository.save(geofence);
        List<Geofence> allGeofences = geofenceRepository.findAll();

        assertThat(allGeofences.size()).isEqualTo(1);
    }
}
