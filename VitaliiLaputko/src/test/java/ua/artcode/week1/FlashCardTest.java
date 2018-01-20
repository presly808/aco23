package ua.artcode.week1;

import org.junit.*;

public class FlashCardTest {

    @Test
    public void checkgetFront() {
        FlashCard flashCard = new FlashCard(1, "en", "ua");
        String expected = "en";
        String actual = flashCard.getFront();

        Assert.assertEquals("getFront() works incorrectly!", expected, actual);
    }

    @Test
    public void checkgetBack() {
        FlashCard flashCard = new FlashCard(1, "en", "ua");
        String expected = "ua";
        String actual = flashCard.getBack();

        Assert.assertEquals("getBack() works incorrectly!", expected, actual);
    }

    @Test
    public void checkGetId() {
        FlashCard flashCard = new FlashCard(1, "en", "ua");
        int expected = 1;
        int actual = flashCard.getId();

        Assert.assertTrue("getBack() works incorrectly!", expected == actual);
    }
}
