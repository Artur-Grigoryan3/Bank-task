package com.company.atm;

import com.company.card.Card;
import com.company.exception.TransactionException;
import com.company.manager.AtmManager;

public class ATM {

    private long balance;
    private AtmManager atmManager;

    public ATM(Card card){
        this.atmManager=new AtmManager(card.getBank().getBankManager());
        this.balance = 300000;
    }

    public void cashOut(long cardNumber, long cashOut) throws TransactionException {
        if (canCashOut(cashOut)) {
            atmManager.cashOut(cardNumber, cashOut);
            updateBalance(cashOut);
        } else {
            throw new TransactionException("ATM does not have enough cash");
        }
    }

    private void updateBalance(long cashOut) {
        balance = balance - cashOut;
    }

    private boolean canCashOut(long cashOut) {
        return balance >= cashOut;
    }
}
