package com.example.ram.desingpatterns.dj;

import com.example.ram.desingpatterns.dj.model.ChargeResult;
import com.example.ram.desingpatterns.dj.model.CreditCard;
import com.example.ram.desingpatterns.dj.model.PizzaOrder;
import com.example.ram.desingpatterns.dj.model.Receipt;

public class RealBillingService implements BillingService {

    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    public RealBillingService(CreditCardProcessor processor,
                              TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        ChargeResult result = processor.charge(creditCard, order.getAmount());
        transactionLog.logChargeResult(result);

        return result.isSuccess()
                ? Receipt.forSuccessfulCharge(order.getAmount())
                : Receipt.forDeclinedCharge(result.getDeclineMessage());
    }
}
