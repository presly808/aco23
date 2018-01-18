package ua.artcode.week1;

import org.junit.*;

import java.security.InvalidParameterException;

public class FlashCardValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkNullFlashCardObjValidation() {
        FlashCardValidator.Validate((FlashCard) null);
    }

    @Test
    public void checkID_FlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate(new FlashCard(-1, "girl", "девочка"));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj ID parameter validation", thrown);
    }

    @Test
    public void checkFrontEmpty_FlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate(new FlashCard(1, "", "девочка"));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj Front parameter validation", thrown);
    }

    @Test
    public void checkFrontNull_FlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate(new FlashCard(1, null, "девочка"));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj Front parameter validation", thrown);
    }

    @Test
    public void checkBackEmpty_FlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate(new FlashCard(1, "girl", ""));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj Back parameter validation", thrown);
    }

    @Test
    public void checkBackNull_FlashCardObjValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate(new FlashCard(1, "girl", null));
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect FlashCardObj Back parameter validation", thrown);
    }

    @Test
    public void checkNegativeIntValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate(-2);
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect Negative Int validation", thrown);
    }

    @Test
    public void checkZeroIntValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate(0);
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect ZeroInt validation", thrown);
    }

    @Test
    public void checkEmptyStringValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate("");
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect ZeroInt validation", thrown);
    }

    @Test
    public void checkNullStringValidation() {
        boolean thrown = false;

        try {
            FlashCardValidator.Validate((String) null);
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertTrue("Incorrect ZeroInt validation", thrown);
    }
}
