package ua.artcode.week1;

import org.junit.*;

import java.security.InvalidParameterException;

public class FlashCardValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkNullFlashCardObjValidation() {
        FlashCardValidator.validate((FlashCard) null);
    }

    @Test
    public void checkIdFlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate(new FlashCard(-1, "girl", "девочка"));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj ID parameter validation", thrown);
    }

    @Test
    public void checkFrontEmptyFlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate(new FlashCard(1, "", "девочка"));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj Front parameter validation", thrown);
    }

    @Test
    public void checkFrontNullFlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate(new FlashCard(1, null, "девочка"));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj Front parameter validation", thrown);
    }

    @Test
    public void checkBackEmptyFlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate(new FlashCard(1, "girl", ""));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj Back parameter validation", thrown);
    }

    @Test
    public void checkBackNullFlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate(new FlashCard(1, "girl", null));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj Back parameter validation", thrown);
    }

    @Test
    public void checkNegativeIntValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate(-2);
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect Negative Int validation", thrown);
    }

    @Test
    public void checkZeroIntValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate(0);
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect ZeroInt validation", thrown);
    }

    @Test
    public void checkEmptyStringValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate("");
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect ZeroInt validation", thrown);
    }

    @Test
    public void checkNullStringValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.validate((String) null);
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect ZeroInt validation", thrown);
    }
}
