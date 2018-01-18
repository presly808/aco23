package ua.artcode.week1;

import java.security.InvalidParameterException;

public class FlashCardValidator {

    public static FlashCard validate(FlashCard card) {
        if (card == null)
            throw new InvalidParameterException("Card obj is null.");

        validate(card.getId());
        validate(card.getFront());
        validate(card.getBack());

        return card;
    }

    public static String validate(String str) {
        if (str == null || str.isEmpty())
            throw new InvalidParameterException("Card value {" + str + "} is null.");

        return str;
    }

    public static int validate(int id) {
        if (id <= 0)
            throw new InvalidParameterException("Card Id{" + id + "} is incorrect");

        return id;
    }
}
