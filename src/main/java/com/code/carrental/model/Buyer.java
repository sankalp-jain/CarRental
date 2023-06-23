package com.code.carrental.model;


import com.code.carrental.enums.UserEnum;

public class Buyer extends CarRentalUser {
    public Buyer(String userId, String name, UserEnum type, String email, String address, Long phoneNo) {
        super(userId, name, type, email, address, phoneNo);
    }
}
