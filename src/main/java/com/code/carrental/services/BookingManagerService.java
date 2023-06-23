package com.code.carrental.services;

import com.code.carrental.dao.BookingRepository;
import com.code.carrental.dao.CarRentPriceRepository;
import com.code.carrental.dao.CarRepository;
import com.code.carrental.dao.PaymentRepository;
import com.code.carrental.enums.BOOKING_STATUS;
import com.code.carrental.enums.PAYMENT_STATUS;
import com.code.carrental.model.Booking;
import com.code.carrental.model.Car;
import com.code.carrental.model.Payment;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingManagerService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    AvailabilityService availabilityService;
    @Autowired
    CarRentPriceRepository carRentPriceRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Getter
    private final List<Car> availableVehicles = new ArrayList<>();

    public Booking book(@NonNull final String carId, @NonNull final String userId, @NonNull final String fromDate, @NonNull final String toDate) {
        String uuid = UUID.randomUUID().toString();

        int price = carRentPriceRepository.findByCarId(carId).getPrice();
        String paymentId = UUID.randomUUID().toString();
        Payment payment = new Payment(paymentId, userId, price, PAYMENT_STATUS.COMPLETED);
        paymentRepository.save(payment);

        LocalDate fromBookingDate = LocalDate.parse(fromDate);
        LocalDate toBookingDate = LocalDate.parse(toDate);
        Booking booking = new Booking(uuid, paymentId, carId, userId, fromBookingDate, toBookingDate, BOOKING_STATUS.ACTIVE);
        bookingRepository.save(booking);
        return booking;
    }

    public void cancel(@NonNull final String bookingId){
        bookingRepository.cancelBooking(BOOKING_STATUS.CANCEL, bookingId);
    }

    public void completeBooking(@NonNull final String bookingId){
        bookingRepository.completeBooking(BOOKING_STATUS.COMPLETE, bookingId);
    }
}
