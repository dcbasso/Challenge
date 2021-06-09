package com.rezolve.challenge.integration;

import com.rezolve.challenge.model.Advertising;
import com.rezolve.challenge.respository.AdvertisingRepository;
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
public class AdvertisingRepositoryIntegrationTest {

    @Autowired
    private AdvertisingRepository advertisingRepository;

    @Test
    public void saveOneAdvertising_thenFindOneWithFindAll() {
        final Advertising advertising = Advertising.builder()
                .url("http://example.com")
                .build();

        advertisingRepository.save(advertising);
        List<Advertising> all = advertisingRepository.findAll();

        assertThat(all.size()).isEqualTo(1);
    }

}
