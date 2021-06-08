package com.rezolve.challenge.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
public class Geofence implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(precision=2, scale=7)
    private Double latitude;

    @Column(precision=2, scale=7)
    private Double longitude;

    private Integer radius;

    @ManyToMany(mappedBy = "geofenceList")
    private List<Advertising> advertisingList;

}
