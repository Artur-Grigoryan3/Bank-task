package com.company;


import com.company.atm.ATM;
import com.company.manager.AtmManager;
import com.company.card.Card;
import com.company.exception.TransactionException;
import com.company.xml.CardParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final String FILE_PATH = "src\\com\\company\\xml\\cards.xml";

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, ParseException, TransactionException {
        Card card = getRandomCard();
        ATM atm = new ATM(card);
        long cashOut = inputCashOut();

        try {
            atm.cashOut(card.getNumber(), cashOut);
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
        }
    }


    private static long inputCashOut() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input how much you want to cash out : ");
        return sc.nextLong();
    }

    private static Card getRandomCard() throws SAXException, ParserConfigurationException, ParseException, IOException {
        List<Card> cards = CardParser.newInstance().parse(FILE_PATH);
        int randomIndex = ThreadLocalRandom.current().nextInt(0, cards.size() - 1);
        return cards.get(randomIndex);
    }
}
