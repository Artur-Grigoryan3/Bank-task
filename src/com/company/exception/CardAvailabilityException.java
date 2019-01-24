package com.company.exception;

public class CardAvailabilityException extends TransactionException {
    public CardAvailabilityException(String message) {
        super(message);
    }
}
