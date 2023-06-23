package com.code.carrental.dao;

import com.code.carrental.model.Booking;
import com.code.carrental.model.CarRentPrice;
import com.code.carrental.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentPriceRepository extends JpaRepository<CarRentPrice, String> {
    CarRentPrice findByCarId(String id);
}
