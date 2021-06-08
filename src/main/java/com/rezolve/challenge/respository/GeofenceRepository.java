package com.rezolve.challenge.respository;

import com.rezolve.challenge.model.Geofence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeofenceRepository extends JpaRepository<Geofence, Integer> {
}
