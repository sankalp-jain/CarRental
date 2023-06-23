package com.code.carrental.model;

import com.code.carrental.enums.PAYMENT_STATUS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    String id;
    String userId;
    Integer price;
    @Enumerated(EnumType.STRING)
    PAYMENT_STATUS paymentStatus;
}
