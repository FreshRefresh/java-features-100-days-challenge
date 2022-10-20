package com.example.ram.desingpatterns.dj.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String state;
    private String zip;

}
