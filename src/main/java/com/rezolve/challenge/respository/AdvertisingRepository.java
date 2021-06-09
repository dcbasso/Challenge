package com.rezolve.challenge.respository;

import com.rezolve.challenge.model.Advertising;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisingRepository extends JpaRepository<Advertising, Integer> {
}
