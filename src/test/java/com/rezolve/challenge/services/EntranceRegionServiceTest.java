package com.rezolve.challenge.services;

import com.rezolve.challenge.dto.EntranceRegionDTO;
import com.rezolve.challenge.model.Advertising;
import com.rezolve.challenge.model.Geofence;
import com.rezolve.challenge.respository.AdvertisingRepository;
import com.rezolve.challenge.services.interfaces.EntranceRegionService;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntranceRegionServiceTest {

    @MockBean
    private AdvertisingRepository advertisingRepository;

    @Autowired
    private EntranceRegionService entranceRegionService;

    @Test
    public void advertingInTheSameSpotShouldReturnOneAdverting() {
        final Geofence geofenceOfAdvertising = Geofence.builder()
                .id(1)
                .radius(10.00)
                .latitude(7.1234567)
                .longitude(1.7654321)
                .build();
        final Advertising advertising = Advertising.builder()
                .href("http://google.com.br")
                .id(1)
                .geofenceList(Arrays.asList(geofenceOfAdvertising))
                .build();

        final EntranceRegionDTO entranceRegionDTO = EntranceRegionDTO.builder()
                .latitude(7.1234567)
                .longitude(1.7654321)
                .build();

        Mockito.when(this.advertisingRepository.findAll()).thenReturn(Arrays.asList(advertising));

        final List<Advertising> advertisingList = this.entranceRegionService.advertisingExists(entranceRegionDTO);
        Assert.assertNotNull(advertisingList);
        Assert.assertFalse(advertisingList.isEmpty());
        Assert.assertEquals(advertising, advertisingList.get(0));
        Assert.assertFalse(advertisingList.get(0).getGeofenceList().isEmpty());
    }

    @Test
    public void advertingInTheSameSpotShouldReturnOneAdvertingEvenHavingTwoAdvertising() {
        final Geofence geofenceOfAdvertisingOne = Geofence.builder()
                .id(1)
                .radius(10.00)
                .latitude(7.1234567)
                .longitude(1.7654321)
                .build();

        final Geofence geofenceOfAdvertisingTwo = Geofence.builder()
                .id(2)
                .radius(100.00)
                .latitude(100.1234567)
                .longitude(100.7654321)
                .build();

        final Advertising advertisingOne = Advertising.builder()
                .href("http://google.com.br")
                .id(1)
                .geofenceList(Arrays.asList(geofenceOfAdvertisingOne))
                .build();

        final Advertising advertisingTwo = Advertising.builder()
                .href("http://uol.com.br")
                .id(2)
                .geofenceList(Arrays.asList(geofenceOfAdvertisingTwo))
                .build();

        final EntranceRegionDTO entranceRegionDTO = EntranceRegionDTO.builder()
                .latitude(100.1234567)
                .longitude(100.7654321)
                .build();

        Mockito.when(this.advertisingRepository.findAll()).thenReturn(Arrays.asList(advertisingOne, advertisingTwo));

        final List<Advertising> advertisingList = this.entranceRegionService.advertisingExists(entranceRegionDTO);
        Assert.assertNotNull(advertisingList);
        Assert.assertFalse(advertisingList.isEmpty());
        Assert.assertEquals(1, advertisingList.size());
        Assert.assertEquals(advertisingTwo, advertisingList.get(0));
        Assert.assertFalse(advertisingList.get(0).getGeofenceList().isEmpty());
    }

    @Test
    public void advertingFarAwayFromSpotShouldReturnZeroAdverting() {
        final Geofence geofenceOfAdvertising = Geofence.builder()
                .id(1)
                .radius(2.00)
                .latitude(7.1234567)
                .longitude(1.7654321)
                .build();
        final Advertising advertising = Advertising.builder()
                .href("http://google.com.br")
                .id(1)
                .geofenceList(Arrays.asList(geofenceOfAdvertising))
                .build();

        final EntranceRegionDTO entranceRegionDTO = EntranceRegionDTO.builder()
                .latitude(100.1234567)
                .longitude(99.7654321)
                .build();

        Mockito.when(this.advertisingRepository.findAll()).thenReturn(Arrays.asList(advertising));

        final List<Advertising> advertisingList = this.entranceRegionService.advertisingExists(entranceRegionDTO);
        Assert.assertNotNull(advertisingList);
        Assert.assertTrue(advertisingList.isEmpty());
    }

}
