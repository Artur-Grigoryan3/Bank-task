package com.company;

import com.company.atm.ATM;
import com.company.card.Card;
import com.company.xml.CardParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Shared {
    private boolean flag = true;
    private Card card;
    private ATM atm;

    public Shared(Card card, ATM atm) {
        this.card = card;
        this.atm = atm;
    }


    public synchronized long inputCashOut() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input how much you want to cash out : ");
        return sc.nextLong();
    }

}
