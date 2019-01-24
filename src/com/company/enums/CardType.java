package com.company.enums;

public enum CardType {
    ARCA("Arca"),
    VISA("Visa"),
    MASTER("Master");

    private String name;

    CardType(String name) {
        this.name = name;
    }

   public static CardType getByName(String name) {
        if (name.equals( "Arca")) {
            return ARCA;
        }
        if (name.equals("Visa")) {
            return VISA;
        }
        if (name.equals("Master")) {
            return MASTER;
        }
        return null;
    }
}
