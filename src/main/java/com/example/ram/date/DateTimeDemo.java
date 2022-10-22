package com.example.ram.date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTimeDemo {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();

        LocalDate payDay = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);

        System.out.println(today);
        System.out.println(payDay);
    }
}
