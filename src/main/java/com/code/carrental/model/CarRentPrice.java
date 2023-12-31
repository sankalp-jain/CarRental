package com.code.carrental.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class CarRentPrice {

    @Id
    String id;
    String carId;
    Integer price;
}
