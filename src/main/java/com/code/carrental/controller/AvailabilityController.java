package com.code.carrental.controller;

import com.code.carrental.model.Car;
import com.code.carrental.services.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("availability")
public class AvailabilityController {

    @Autowired
    AvailabilityService availabilityService;

    @GetMapping("getAvailableCars")
    public List<Car> getAvailableCars(@RequestParam String carCentralZoneId, @RequestParam String fromDate, @RequestParam String toDate) {
        return availabilityService.getAvailableCars(carCentralZoneId, fromDate, toDate);
    }
}
