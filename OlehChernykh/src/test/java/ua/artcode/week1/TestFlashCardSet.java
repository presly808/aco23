package ua.artcode.week1;

import org.junit.Assert;
import org.junit.Test;

public class TestFlashCardSet {

    private FlashCardSet flashCardSet = new FlashCardSet(3,"B");
    private FlashCard card = new FlashCard(2,"Front", "Back");

    @Test
    public void getListId(){
        FlashCardSet flashCardSet = new FlashCardSet(1, "Birds");
        int expected = 1;
        int actual = flashCardSet.getListId();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void getTopic(){
        FlashCardSet flashCardSet = new FlashCardSet(1, "Birds");
        String expected = "Birds";
        String actual = flashCardSet.getTopic();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void setCardId(){
        flashCardSet.setListId(2);
        Assert.assertEquals(2,flashCardSet.getListId());
    }

    @Test
    public void setTopic(){
        flashCardSet.setTopic("Languages");
        Assert.assertEquals("Languages",flashCardSet.getTopic());
    }

    @Test
    public void addFlashCard(){
        Assert.assertEquals(true,flashCardSet.add(card));
    }

    @Test
    public void addEmpty(){
        card = null;
        Assert.assertEquals(false,flashCardSet.add(card));
    }

    @Test
    public void remove(){
        flashCardSet.add(card);
        Assert.assertEquals(true,flashCardSet.remove(flashCardSet.cards,0));
    }

    @Test
    public void removeEmpty(){
        Assert.assertEquals(false,flashCardSet.remove(flashCardSet.cards,3));
    }

    @Test
    public void showAll(){
        flashCardSet.add(card);
        Assert.assertEquals(true,flashCardSet.showAll());
    }

}
