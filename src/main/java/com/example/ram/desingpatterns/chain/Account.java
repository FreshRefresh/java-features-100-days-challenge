package com.example.ram.desingpatterns.chain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Account {
    private Long accountId;
    private String accountName;
}
