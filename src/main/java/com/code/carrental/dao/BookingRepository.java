package com.code.carrental.dao;

import com.code.carrental.enums.BOOKING_STATUS;
import com.code.carrental.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    List<Booking> findByCarId(String id);

    @Transactional
    @Modifying
    @Query("update Booking booking set booking.bookingStatus = :status where booking.bookingId = :id")
    int cancelBooking(@Param("status") BOOKING_STATUS status, @Param("id") String id);

    @Transactional
    @Modifying
    @Query("update Booking booking set booking.bookingStatus = :status where booking.bookingId = :id")
    int completeBooking(@Param("status") BOOKING_STATUS status, @Param("id") String id);
}
