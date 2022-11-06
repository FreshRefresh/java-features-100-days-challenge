package com.example.ram.desingpatterns.chain;

public class AccountProcessorApp {

    public static void main(String[] args) {

        AccountProcessor loggingProcessor = new AccountLoggingProcessor();
        AccountProcessor validatorProcessor = new AccountValidatorProcessor(loggingProcessor);
        validatorProcessor.processAccount(Account.builder().accountId(1L).accountName("Savings").build());
    }
}
