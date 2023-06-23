package com.code.carrental.services;


import com.code.carrental.dao.BookingRepository;
import com.code.carrental.dao.CarCentralZoneRepository;
import com.code.carrental.enums.BOOKING_STATUS;
import com.code.carrental.model.Booking;
import com.code.carrental.model.Car;
import com.code.carrental.model.CarRentalZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AvailabilityService {

    @Autowired
    CarCentralZoneRepository carCentralZoneRepository;
    @Autowired
    BookingRepository bookingRepository;

    public List<Car> getAvailableCars(String carCentralZoneId, String fromDate, String toDate) {

        List<Car> availableCars = new ArrayList<>();
        LocalDate localFromDate = LocalDate.parse(fromDate);
        LocalDate localToDate = LocalDate.parse(toDate);
        CarRentalZone carRentalZone = carCentralZoneRepository.findById(carCentralZoneId).get();
        List<Car> cars = carRentalZone.getCars();
        for (Car car : cars) {
            List<Booking> bookings = bookingRepository.findByCarId(car.getId());
            if (bookings.size() == 0) {
                availableCars.add(car);
            } else {
                for (Booking booking : bookings) {
                    LocalDate bookingFromDate = booking.getFromDate();
                    LocalDate bookingToDate = booking.getToDate();

                    if (booking.getBookingStatus().equals(BOOKING_STATUS.ACTIVE) && (localFromDate.isAfter(bookingToDate) || localToDate.isBefore(bookingFromDate))) {
                        availableCars.add(car);
                        break;
                    }
                }
            }
        }
        return availableCars;
    }
}
