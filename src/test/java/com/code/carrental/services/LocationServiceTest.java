package com.code.carrental.services;

import com.code.carrental.dao.LocationRepository;
import com.code.carrental.model.CarRentalZone;
import com.code.carrental.model.Location;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LocationServiceTest {

    @Autowired
    LocationService locationService;

    @MockBean
    LocationRepository locationRepository;

    @Test
    void getLocations() {
        List<CarRentalZone> carRentalZones = new ArrayList<>();
        Location location = new Location("id", "description", carRentalZones);
        List<Location> locations = new ArrayList<>();
        locations.add(location);
        Mockito.when(locationRepository.findAll()).thenReturn(locations);


        List<Location> l = locationService.getLocations();
        assertEquals(locations.size(), l.size());
        assertEquals(locations, l);
    }

    @Test
    void saveLocations() {
    }
}