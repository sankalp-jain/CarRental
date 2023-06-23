package com.code.carrental.dao;

import com.code.carrental.model.Location;
import com.code.carrental.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

}
