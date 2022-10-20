package com.example.ram.desingpatterns.dj.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreditCard {
    private String creditCardNumber;
    private String expDate;
    private int ccv;
    private Address billingAddress;
}
