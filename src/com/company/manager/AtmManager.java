package com.company.manager;

import com.company.exception.TransactionException;

public class AtmManager {

    private BankManager bankManager;

    public AtmManager(BankManager bankManager) {
        this.bankManager = bankManager;
    }

    public void cashOut(long cardNumber, long cash) throws TransactionException {
        if (bankManager.canCashOut(cardNumber, cash)) {
            bankManager.cashOut(cardNumber, cash);
        }
    }

}
