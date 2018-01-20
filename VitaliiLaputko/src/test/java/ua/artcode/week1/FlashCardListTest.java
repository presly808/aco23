package ua.artcode.week1;

import org.junit.Assert;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class FlashCardListTest {

    @Test
    public void checkAddCardToList() {
        FlashCardList flashCardList = new FlashCardList();
        boolean actual = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));

        Assert.assertThat("addCardToList method works incorrectly", actual, is(equalTo(true)));
    }

    @Test
    public void checkAddCardToListDiffId() {
        FlashCardList flashCardList = new FlashCardList();
        boolean actual1 = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
        boolean actual2 = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(2, "girl", "девочка")));

        Assert.assertThat(actual1, is(equalTo(true)));
        Assert.assertThat(actual2, is(equalTo(true)));
    }

    @Test
    public void checkAddTheSameCardToList() {
        FlashCardList flashCardList = new FlashCardList();
        boolean actual1 = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
        boolean actual2 = flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));

        Assert.assertThat(actual1, is(true));
        Assert.assertThat(actual2, is(false));
    }

    @Test
    public void checkDeleteCardFromListByFrontValue() {
        FlashCardList flashCardList = new FlashCardList();
        flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
        boolean actual = flashCardList.deleteCardFromListById(1);

        Assert.assertThat(actual, is(true));
    }

    @Test
    public void checkDeleteCardFromListByFrontValueNegative() {
        FlashCardList flashCardList = new FlashCardList();
        flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
        boolean actual = flashCardList.deleteCardFromListById(2);

        Assert.assertThat(actual, is(false));
    }

    @Test
    public void checkDeleteCardFromListById() {
        FlashCardList flashCardList = new FlashCardList();
        flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
        boolean actual = flashCardList.deleteCardFromListById(1);

        Assert.assertThat(actual, is(true));
    }

    @Test
    public void checkDeleteCardFromListByIdNegative() {
        FlashCardList flashCardList = new FlashCardList();
        flashCardList.addCardToList(FlashCardValidator.validate(new FlashCard(1, "girl", "девочка")));
        boolean actual = flashCardList.deleteCardFromListById(2);

        Assert.assertThat(actual, is(false));
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

        Assert.assertThat("PrintCardList method works incorrectly", thrown, is(false));
    }
}
