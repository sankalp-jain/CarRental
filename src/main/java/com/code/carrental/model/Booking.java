package com.code.carrental.model;

import com.code.carrental.enums.BOOKING_STATUS;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    String bookingId;
    String paymentId;
    String carId;
    String userId;
    LocalDate fromDate;
    LocalDate toDate;
    @Enumerated(EnumType.STRING)
    BOOKING_STATUS bookingStatus;
}
