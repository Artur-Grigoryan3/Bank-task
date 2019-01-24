package com.company.xml;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import com.company.bank.Bank;
import com.company.account.Account;
import com.company.card.Card;
import com.company.customer.Customer;
import com.company.enums.CardType;
import com.company.enums.Currency;
import com.company.enums.IssuerBank;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class CardParser {
    static CardParser parser;

    private static final DateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

    private CardParser() {
    }

    public static CardParser newInstance() {
        if (parser == null) {
            parser = new CardParser();
        }
        return parser;
    }

    public List<Card> parse(String filePath) throws IOException, SAXException, ParserConfigurationException, ParseException {
        List<Card> cards = new ArrayList<>();
        Document doc = getDocument(new File(filePath));
        NodeList nList = doc.getElementsByTagName("card");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Card card = new Card();
                Element eElement = (Element) nNode;
                card.setNumber(Long.parseLong(eElement.getElementsByTagName("cardNumber").item(0).getTextContent()));
                card.setType(CardType.getByName(eElement.getElementsByTagName("cardBrand").item(0).getTextContent()));
                card.setCurrency(Currency.valueOf(eElement.getElementsByTagName("currency").item(0).getTextContent()));
                card.setHolder(new Customer(eElement.getElementsByTagName("cardHolder").item(0).getTextContent()));
                card.setExpireDate(FORMATTER.parse(eElement.getElementsByTagName("expireDate").item(0).getTextContent()));

                Bank bank = IssuerBank.getByName(eElement.getElementsByTagName("issuerBank").item(0).getTextContent()).getBank();
                bank.addCard(card, new Account());
                cards.add(card);
            }
        }

        return cards;
    }


    private Document getDocument(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        return doc;
    }
}
