package com.example.ram.desingpatterns.chain;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class AccountValidatorProcessor implements AccountProcessor {

    private AccountProcessor delegate;

    @Override
    public void processAccount(Account account) {

        System.out.println("Validation looks good for account " + account.getAccountId());
        System.out.println("Validation looks good for account " + account.getAccountName());
        
        delegate.processAccount(account);
    }
}
