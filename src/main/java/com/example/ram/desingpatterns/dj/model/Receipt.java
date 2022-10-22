package com.example.ram.desingpatterns.dj.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Receipt {
    private long receiptNumber;
    private Double chargeAmount;
    private String declineMessage;


    public static Receipt forSuccessfulCharge(Double amount) {
        return Receipt.builder().chargeAmount(amount).build();
    }

    public static Receipt forDeclinedCharge(String declineMessage) {
        return Receipt.builder().declineMessage(declineMessage).build();
    }

    public static Receipt forSystemFailure(String message) {
        return Receipt.builder().declineMessage(message).build();
    }
}
