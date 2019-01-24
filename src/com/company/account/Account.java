package com.company.account;

import java.util.UUID;

public class Account {
    private long balance;
    private long number;

    public Account() {
        balance = 100000;
        number = UUID.randomUUID().getMostSignificantBits();
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                "number=" + number +
                '}';
    }
}
