package com.example.ram.desingpatterns.dj;

import com.example.ram.desingpatterns.dj.model.ChargeResult;
import com.example.ram.desingpatterns.dj.model.CreditCard;

public interface CreditCardProcessor {

    ChargeResult charge(CreditCard creditCard, Double amount);
}
