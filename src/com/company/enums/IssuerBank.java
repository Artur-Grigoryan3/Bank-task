package com.company.enums;

import com.company.bank.AmeriaBank;
import com.company.bank.Bank;
import com.company.bank.HSBCBank;
import com.company.bank.InecoBank;

public enum IssuerBank {
    AMERIA("AmeriaBank") {
        private Bank bank;

        @Override
        public Bank getBank() {
            if (bank == null) {
                bank = new AmeriaBank();
            }
            return bank;
        }
    },
    INECO("InecoBank") {
        private Bank bank;

        @Override
        public Bank getBank() {
            if (bank == null) {
                bank = new InecoBank();
            }
            return bank;
        }
    },
    HSBC("HSBC") {
        private Bank bank;

        @Override
        public Bank getBank() {
            if (bank == null) {
                bank = new HSBCBank();
            }
            return bank;
        }
    };

    String name;

    IssuerBank(String name) {
        this.name = name;
    }

    public static IssuerBank getByName(String name) {
        if (name.equals("AmeriaBank")) {
            return AMERIA;
        }
        if (name.equals("InecoBank")) {
            return INECO;
        }
        if (name.equals("HSBC")) {
            return HSBC;
        }
        return null;
    }

    public abstract Bank getBank();
}
