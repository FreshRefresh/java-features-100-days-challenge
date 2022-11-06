package com.example.ram.desingpatterns.chain;

public class AccountLoggingProcessor implements AccountProcessor {
    @Override
    public void processAccount(Account account) {
        System.out.println("Logging Account Id in File - " + account.getAccountId());
        System.out.println("Logging Account Id in File - " + account.getAccountName());
    }
}
