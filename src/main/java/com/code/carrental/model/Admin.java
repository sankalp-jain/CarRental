package com.code.carrental.model;

import com.code.carrental.enums.UserEnum;


public class Admin extends CarRentalUser{
    public Admin(String userId, String name, UserEnum type, String email, String address, Long phoneNo) {
        super(userId, name, type, email, address, phoneNo);
    }
}
