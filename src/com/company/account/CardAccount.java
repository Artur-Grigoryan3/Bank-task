package com.company.account;

import com.company.card.Card;

public class CardAccount {
    private Card card;
    private Account account;

    public CardAccount(Card card, Account account) {
        this.card = card;
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public Account getAccount() {
        return account;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
