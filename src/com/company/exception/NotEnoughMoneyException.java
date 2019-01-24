package com.company.exception;

public class NotEnoughMoneyException extends TransactionException {
    public NotEnoughMoneyException(String messsage) {
        super(messsage);
    }
}
