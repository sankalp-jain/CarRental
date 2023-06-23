package com.code.carrental.controller;

import com.code.carrental.model.Car;
import com.code.carrental.services.SearchInventoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchInventoryService searchInventoryService;

    @GetMapping("model")
    public List<Car> searchCarByModel(@RequestParam String carRentalZoneId, @RequestParam String model) {
        return searchInventoryService.searchCarByModel(carRentalZoneId, model);
    }

    @GetMapping("year")
    public List<Car> searchCarByYear(@RequestParam @NonNull final String carRentalZoneId, @RequestParam @NonNull final String year) {
        return searchInventoryService.searchCarByYear(carRentalZoneId, year);
    }
}
