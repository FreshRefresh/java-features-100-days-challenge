package com.example.ram.desingpatterns.dj.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Receipt {
    private long receiptNumber;
    private Double chargeAmount;
}
