package ua.artcode.week1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardListTest {

    @Test
    public void addCard() {
        FlashCard flashCard = new FlashCard(2,"front","back");
        CardList cardList = new CardList();
        cardList.addCard(flashCard);
        Assert.assertEquals(true,cardList.addCard(flashCard));
    }

    @Test
    public void remove() {
        FlashCard flashCard = new FlashCard(2,"front","back");
        CardList cardList = new CardList();
        cardList.addCard(flashCard);
        cardList.remove(2);
        Assert.assertEquals(true,cardList.remove(2));

    }

   /* @Test
    public void getAll() {
        FlashCard flashCard = new FlashCard(2,"front","back");
        CardList cardList = new CardList();
        cardList.addCard(flashCard);
        cardList.getAll();
        Assert.assertEquals(cardList,cardList.getCards());

    }*/

    @Test
    public void getId() {
        FlashCard flashCard = new FlashCard(1,"sfssf","kjkjb");
        int expected = 1;
        int actual = flashCard.getId();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setId() {
        CardList cardList = new CardList();
        cardList.setId(1);
        Assert.assertEquals(1, cardList.getId());
    }

    @Test
    public void getSize() {
        CardList cardList = new CardList();
        int expected = 0;
        int actual = cardList.getSize();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void setSize() {
        CardList cardList = new CardList();
        cardList.setSize(0);
        Assert.assertEquals(0 , cardList.getSize());
    }
}