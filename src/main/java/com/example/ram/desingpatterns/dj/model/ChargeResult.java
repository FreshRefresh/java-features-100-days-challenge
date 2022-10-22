package com.example.ram.desingpatterns.dj.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ChargeResult {
    private boolean isSuccess;
    private String declineMessage;

}
