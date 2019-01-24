package com.company.card;


import com.company.bank.Bank;
import com.company.customer.Customer;
import com.company.enums.CardType;
import com.company.enums.Currency;

import java.util.Date;

public class Card {
    private long number;
    private CardType type;
    private Currency currency;
    private Bank bank;
    private Customer holder;
    private Date expireDate;

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getHolder() {
        return holder;
    }

    public void setHolder(Customer holder) {
        this.holder = holder;
        this.holder.addCard(this);
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + number +
                ", bank=" + bank +
                ", currency=" + currency +
                ", customer=" + holder +
                ", expireDate=" + expireDate +
                ", type=" + type +
                '}';
    }
}
