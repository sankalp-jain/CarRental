package com.code.carrental.model;

import com.code.carrental.enums.CAR_RENTAL_ZONE_STATUS;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class CarRentalZone {

    @Id
    String id;
    String description;
    @OneToMany(targetEntity = Car.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "car_central_zone_fk", referencedColumnName = "id")
    List<Car> cars;

    @Enumerated(EnumType.STRING)
    CAR_RENTAL_ZONE_STATUS carRentalZoneStatus;
}
