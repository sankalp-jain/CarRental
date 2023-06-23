package com.code.carrental.dao;

import com.code.carrental.model.Car;
import com.code.carrental.model.CarRentalZone;
import com.code.carrental.services.CarCentralZoneService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCentralZoneRepository extends JpaRepository<CarRentalZone, String> {

}
