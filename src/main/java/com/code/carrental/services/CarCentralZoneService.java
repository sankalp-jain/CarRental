package com.code.carrental.services;

import com.code.carrental.dao.CarCentralZoneRepository;
import com.code.carrental.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarCentralZoneService {

    @Autowired
    CarCentralZoneRepository carCentralZoneRepository;

    public List<Car> getAllCars(String id) {
        return carCentralZoneRepository.findById(id).get().getCars();
    }
}
