package com.code.carrental.model;

import com.code.carrental.enums.UserEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CarRentalUser {

    @Id
    private String id;
    private String name;
    private UserEnum type;
    private String email;
    private String address;
    private Long phoneNo;
}
