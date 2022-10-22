package com.example.ram.desingpatterns.dj;

import com.example.ram.desingpatterns.dj.model.ChargeResult;

public class DatabaseTransactionLog implements TransactionLog {

    @Override
    public void logChargeResult(ChargeResult chargeResult) {

    }

    @Override
    public void logConnectException(UnreachableException e) {

    }
}
