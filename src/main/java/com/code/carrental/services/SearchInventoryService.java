package com.code.carrental.services;

import com.code.carrental.model.Car;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchInventoryService {
    private final CarCentralZoneService carCentralZoneService;

    public List<Car> searchCarByModel(String id, String model) {
        return carCentralZoneService.getAllCars(id).stream()
                .filter(car -> car.getModel().equals(model))
                .collect(Collectors.toList());
    }

    public List<Car> searchCarByYear(@NonNull final String id, @NonNull final String year) {
        return carCentralZoneService.getAllCars(id).stream()
                .filter(car -> car.getVersionYear().equals(year))
                .collect(Collectors.toList());
    }
}
