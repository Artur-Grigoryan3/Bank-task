package com.company.bank;

import com.company.account.Account;
import com.company.account.CardAccount;
import com.company.card.Card;
import com.company.manager.BankManager;

import java.util.HashMap;
import java.util.Map;

public abstract class Bank {
    private String name;
    private BankManager bankManager;

    private Map<Long, CardAccount> cards = new HashMap<>();

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
        this.bankManager = new BankManager(this);
    }

    public Map<Long, CardAccount> getCards() {
        return cards;
    }

    public void addCard(Card card, Account account) {
        cards.put(card.getNumber(), new CardAccount(card, account));
        card.setBank(this);
    }

    public BankManager getBankManager() {
        return bankManager;
    }

    public void setBankManager(BankManager bankManager) {
        this.bankManager = bankManager;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name=" + name +
                '}';
    }
}
