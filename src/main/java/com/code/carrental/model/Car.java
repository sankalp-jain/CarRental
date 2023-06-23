package com.code.carrental.model;

import com.code.carrental.enums.CAR_STATUS;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Car {

    @Id
    String id;
    String model;
    String versionYear;
    String fuelType;

    @Enumerated(EnumType.STRING)
    CAR_STATUS carStatus;
}
