package com.example.ram.desingpatterns.dj;

import com.example.ram.desingpatterns.dj.model.ChargeResult;
import com.example.ram.desingpatterns.dj.model.CreditCard;

public class FakeCreditCardProcessor implements CreditCardProcessor{
    @Override
    public ChargeResult charge(CreditCard creditCard, Double amount) {
        return null;
    }
}
