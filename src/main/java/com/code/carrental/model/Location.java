package com.code.carrental.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @JsonProperty
    String id;
    @JsonProperty
    String description;
    @OneToMany(targetEntity = CarRentalZone.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_fk", referencedColumnName = "id")
    List<CarRentalZone> carCentralZones;
}
