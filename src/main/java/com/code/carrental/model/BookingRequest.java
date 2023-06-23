package com.code.carrental.model;

import com.code.carrental.enums.BOOKING_STATUS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    String carId;
    String userId;
    String fromDate;
    String toDate;
}
