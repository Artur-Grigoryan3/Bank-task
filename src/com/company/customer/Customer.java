package com.company.customer;

import com.company.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String fullName;

    public Customer(String fullName) {
        this.fullName = fullName;
    }

    private List<Card> cards = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fullName=" + fullName +
                '}';
    }
}
