package com.code.carrental.services;

import com.code.carrental.dao.LocationRepository;
import com.code.carrental.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public void saveLocations(Location location) {
        locationRepository.save(location);
    }
}
