package com.example.ram.desingpatterns.dj;

import com.example.ram.desingpatterns.dj.model.ChargeResult;

public interface TransactionLog {

    void logChargeResult(ChargeResult chargeResult);

    void logConnectException(UnreachableException e);
}
