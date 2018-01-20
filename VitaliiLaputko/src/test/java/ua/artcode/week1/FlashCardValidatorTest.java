package ua.artcode.week1;

import org.junit.*;

import java.security.InvalidParameterException;

public class FlashCardValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkNullFlashCardObjValidation() {
        FlashCardValidator.validate((FlashCard) null);
    }

    @Test(expected=InvalidParameterException.class)
    public void checkIdFlashCardObjValidation() {
        FlashCardValidator.validate(new FlashCard(-1, "girl", "девочка"));
    }

    @Test(expected=InvalidParameterException.class)
    public void checkFrontEmptyFlashCardObjValidation() {
        FlashCardValidator.validate(new FlashCard(1, "", "девочка"));
    }

    @Test(expected=InvalidParameterException.class)
    public void checkFrontNullFlashCardObjValidation() {
        FlashCardValidator.validate(new FlashCard(1, null, "девочка"));
    }

    @Test(expected=InvalidParameterException.class)
    public void checkBackEmptyFlashCardObjValidation() {
        FlashCardValidator.validate(new FlashCard(1, "girl", ""));
    }

    @Test(expected=InvalidParameterException.class)
    public void checkBackNullFlashCardObjValidation() {
        FlashCardValidator.validate(new FlashCard(1, "girl", null));
    }

    @Test(expected=InvalidParameterException.class)
    public void checkNegativeIntValidation() {
        FlashCardValidator.validate(-2);
    }

    @Test(expected=InvalidParameterException.class)
    public void checkZeroIntValidation() {
        FlashCardValidator.validate(0);
    }

    @Test(expected=InvalidParameterException.class)
    public void checkEmptyStringValidation() {
        FlashCardValidator.validate("");
    }

    @Test(expected=InvalidParameterException.class)
    public void checkNullStringValidation() {
        FlashCardValidator.validate((String) null);
    }
}
