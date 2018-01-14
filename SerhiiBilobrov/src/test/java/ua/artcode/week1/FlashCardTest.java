package ua.artcode.week1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serhii on 14.01.18.
 */
public class FlashCardTest {
    @Test
    public void getFront() throws Exception {
        FlashCard flashCard = new FlashCard("a","b");

        String expected = "a";
        String actual = flashCard.getFront();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBack() throws Exception {
        FlashCard flashCard = new FlashCard();

        flashCard.setBack("b");

        String expected = "b";
        String actual = flashCard.getBack();

        Assert.assertEquals(expected, actual);
    }

}