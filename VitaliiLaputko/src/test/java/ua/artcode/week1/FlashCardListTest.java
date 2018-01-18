package ua.artcode.week1;

import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

public class FlashCardListTest {

    @Test
    public void checkAddCardToList() {
        FlashCardList flashCardList = new FlashCardList();
        boolean expected = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));

        Assert.assertTrue("addCardToList method works incorrectly", expected);
    }

    @Test
    public void checkAddCardToListDiffId() {
        FlashCardList flashCardList = new FlashCardList();
        boolean expected1 = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
        boolean expected2 = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(2, "girl", "девочка")));

        Assert.assertEquals("addCardToList method works incorrectly", expected1, expected2);
    }

    @Test
    public void checkAddTheSameCardToList() {
        FlashCardList flashCardList = new FlashCardList();
        boolean actual = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
        boolean expected = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));

        Assert.assertTrue(actual);
        Assert.assertFalse(expected);
    }

    @Test
    public void checkDeleteCardFromListByFrontValue() {
        FlashCardList flashCardList = new FlashCardList();
        flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));

        Assert.assertTrue(flashCardList.deleteCardFromListById(1));
    }

    @Test
    public void checkDeleteCardFromListByFrontValueNegative() {
        FlashCardList flashCardList = new FlashCardList();
        flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));

        Assert.assertFalse(flashCardList.deleteCardFromListById(2));
    }

    @Test
    public void checkDeleteCardFromListById() {
        FlashCardList flashCardList = new FlashCardList();
        flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));

        Assert.assertTrue(flashCardList.deleteCardFromListById(1));
    }

    @Test
    public void checkDeleteCardFromListByIdNegative() {
        FlashCardList flashCardList = new FlashCardList();
        flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));

        Assert.assertFalse(flashCardList.deleteCardFromListById(2));
    }

    @Test
    public void checkPrintCardList() {
        boolean thrown = false;

        try {
            FlashCardList flashCardList = new FlashCardList();
            flashCardList.printCardList();

            flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
            flashCardList.printCardList();
        } catch (InvalidParameterException e) {
            thrown = true;
        }

        Assert.assertFalse("PrintCardList method works incorrectly", thrown);
    }
}
