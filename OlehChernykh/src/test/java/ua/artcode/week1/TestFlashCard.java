package ua.artcode.week1;

import org.junit.Assert;
import org.junit.Test;



public class TestFlashCard {

    @Test
    public void getCardId(){
        FlashCard flashCard = new FlashCard(1,"Run", "Бігти");

        int expected = 1;
        int actual = flashCard.getCardId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getFrontSide(){
        FlashCard flashCard = new FlashCard(1,"Run", "Бігти");

        String expected = "Run";
        String actual = flashCard.getFrontSide();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getBackSide(){
        FlashCard flashCard = new FlashCard(1,"Run", "Бігти");

        String expected = "Бігти";
        String actual = flashCard.getBackSide();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setCardId(){
        FlashCard card = new FlashCard();

        card.setCardId(1);
        Assert.assertEquals(1,card.getCardId());
    }

    @Test
    public void setFrontSide(){
        FlashCard card = new FlashCard();

        card.setFrontSide("Run");
        Assert.assertEquals("Run",card.getFrontSide());
    }

    @Test
    public void setBackSide(){
        FlashCard card = new FlashCard();
        card.setBackSide("C");
        Assert.assertEquals("C",card.getBackSide());
    }






}
