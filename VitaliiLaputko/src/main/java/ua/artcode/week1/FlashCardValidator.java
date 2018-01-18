package ua.artcode.week1;

import java.security.InvalidParameterException;

public class FlashCardValidator {

    public static FlashCard Validate(FlashCard card) {
        if (card == null)
            throw new InvalidParameterException("Card obj is null.");

        Validate(card.getId());
        Validate(card.getFront());
        Validate(card.getBack());

        return card;
    }

    public static String Validate(String str) {
        if (str == null || str.isEmpty())
            throw new InvalidParameterException("Card value {" + str + "} is null.");

        return str;
    }

    public static int Validate(int id) {
        if (id <= 0)
            throw new InvalidParameterException("Card Id{" + id + "} is incorrect");

        return id;
    }
}
