package com.rezolve.challenge.services;

import com.rezolve.challenge.dto.EntranceRegionDTO;
import com.rezolve.challenge.model.Advertising;
import com.rezolve.challenge.model.Geofence;
import com.rezolve.challenge.respository.AdvertisingRepository;
import com.rezolve.challenge.services.interfaces.EntranceRegionService;
import com.rezolve.challenge.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntranceRegionServiceImpl implements EntranceRegionService {

    @Autowired
    private AdvertisingRepository advertisingRepository;

    @Override
    public List<Advertising> advertisingExists(final EntranceRegionDTO entranceRegionDTO) {
        final List<Advertising> advertisingList = this.advertisingRepository.findAll();
        final List<Advertising> filteredAdvertisingList = new ArrayList<>();
        advertisingList.forEach(advertising -> filteredAdvertisingList.add(filterAdvertising(advertising, entranceRegionDTO)));
        return filteredAdvertisingList.parallelStream().filter(advertising -> !advertising.getGeofenceList().isEmpty()).collect(Collectors.toList());
    }

    /**
     * Filder all {@link com.rezolve.challenge.model.Geofence} of {@link com.rezolve.challenge.model.Advertising} base of localtion {@link com.rezolve.challenge.dto.EntranceRegionDTO}
     * @param advertising
     * @param entranceRegionDTO
     * @return
     */
    private Advertising filterAdvertising(final Advertising advertising, final EntranceRegionDTO entranceRegionDTO)  {
        final List<Geofence> geofenceList = advertising.getGeofenceList()
                .stream()
                .filter(geofence -> needToShowGeofence(entranceRegionDTO, geofence))
                .collect(Collectors.toList());
        return Advertising.builder()
                .geofenceList(geofenceList)
                .id(advertising.getId())
                .href(advertising.getHref())
                .build();
    }

    /**
     * check if location of "user" is inside the radius of {@link com.rezolve.challenge.model.Geofence}
     *
     * @param entranceRegionDTO
     * @param geofence
     * @return {@link java.lang.Boolean}
     */
    private Boolean needToShowGeofence(final EntranceRegionDTO entranceRegionDTO, final Geofence geofence) {
        final double distance = distance(entranceRegionDTO.getLatitude(), entranceRegionDTO.getLongitude(), geofence.getLatitude(), geofence.getLongitude(), Constants.UNIT_METERS);
        return distance <= geofence.getRadius();
    }

    /**
     * This method is original from:
     * @see <a href="https://gist.github.com/marconvcm/8a8a953ad034052279668711e26d2fd9"></a>
     *
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @param unit
     * @return
     */
    private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
