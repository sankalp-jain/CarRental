package com.code.carrental.controller;

import com.code.carrental.model.Booking;
import com.code.carrental.model.BookingRequest;
import com.code.carrental.services.BookingManagerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private final BookingManagerService bookingManagerService;

    @PostMapping(path = "createBooking", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Booking book(@RequestBody BookingRequest bookingRequest) {
        return bookingManagerService.book(bookingRequest.getCarId(), bookingRequest.getUserId(), bookingRequest.getFromDate(), bookingRequest.getToDate());
    }

    @PostMapping(path = "cancelBooking", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void cancel(@RequestBody @NonNull String bookingId) {
        bookingManagerService.cancel(bookingId);
    }

    @PostMapping(path = "returnVehicle", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void returnVehicle(@NonNull String bookingId) {
        bookingManagerService.completeBooking(bookingId);
    }
}
