package ua.artcode.week1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlashCardTest  {

    @Test
    public void getFront() throws Exception{
        FlashCard flashCard = new FlashCard(1,"a","b");
        Assert.assertEquals("a",flashCard.getFront());
    }

    @Test
    public void getBack() throws Exception{
        FlashCard flashCard = new FlashCard(2,"sf","oij");
        Assert.assertEquals("oij", flashCard.getBack());
    }

    @Test
    public void getId() {
        FlashCard flashCard = new FlashCard(3,"sfsf","lk");
        Assert.assertEquals(3,flashCard.getId());
    }

    @Test
    public void convertFlashCard() {
        FlashCard flashCard = new FlashCard(1,"sfs","awea");
        flashCard.convertFlashCard();
    }
}