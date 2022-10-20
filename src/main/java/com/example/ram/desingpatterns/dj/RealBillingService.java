package com.example.ram.desingpatterns.dj;

import com.example.ram.desingpatterns.dj.model.CreditCard;
import com.example.ram.desingpatterns.dj.model.PizzaOrder;
import com.example.ram.desingpatterns.dj.model.Receipt;

public class RealBillingService implements BillingService {

    @Override
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        return null;
    }
}
