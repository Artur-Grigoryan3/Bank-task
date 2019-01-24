package com.company.manager;

import com.company.account.Account;
import com.company.account.CardAccount;
import com.company.bank.Bank;
import com.company.exception.CardAvailabilityException;
import com.company.exception.NotEnoughMoneyException;
import com.company.exception.TransactionException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BankManager {
    private static Logger LOG = Logger.getLogger(BankManager.class.getName());

    private Bank bank;

    public BankManager(Bank bank) {
        this.bank = bank;
    }

    public boolean canCashOut(long cardNumber, long cash) throws TransactionException {
        return checkCardExistence(cardNumber) && checkCardBalance(cardNumber, cash);
    }

    public void cashOut(long cardNumber, long cash) {
        CardAccount details = bank.getCards().get(cardNumber);
        Account account = details.getAccount();
        LOG.log(Level.INFO, "Current account balance is {0}", new Object[]{account.getBalance()});
        LOG.log(Level.INFO, "Cashing out for card << {0} >> with cash = {1}", new Object[]{cardNumber, cash});
        details.getAccount().setBalance(account.getBalance() - cash);
        LOG.log(Level.INFO, "Balance for account with number << {0} >> is updated. New balance is {1}", new Object[]{account.getNumber(), account.getBalance()});
    }

    private boolean checkCardExistence(long cardNumber) throws TransactionException {
        LOG.log(Level.INFO, "Checking card << {0} >> existence", new Object[]{cardNumber});
        if (bank.getCards().get(cardNumber) != null) {
            LOG.log(Level.INFO, "Card << {0} >> exists", new Object[]{cardNumber});
            return true;
        }
        throw new CardAvailabilityException("Card does not exists");
    }

    private boolean checkCardBalance(long cardNumber, long cash) throws TransactionException {
        LOG.log(Level.INFO, "Checking balance for card << {0} >>", new Object[]{cardNumber});
        CardAccount details = bank.getCards().get(cardNumber);
        if (details.getAccount().getBalance() >= cash) {
            LOG.log(Level.INFO, "Card  << {0} >> has enough balance ", new Object[]{cardNumber});
            return true;
        }
        throw new NotEnoughMoneyException("Card does not have enough balance");

    }

}
