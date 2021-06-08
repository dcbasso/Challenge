package com.rezolve.challenge.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
public class Advertising implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 2048)
    private String url;

    @ManyToMany
    @JoinTable(name = "advertising_geofence", joinColumns = @JoinColumn(name = "geofenceid"), inverseJoinColumns = @JoinColumn(name = "advertisingid"))
    private List<Geofence> geofenceList;

}
