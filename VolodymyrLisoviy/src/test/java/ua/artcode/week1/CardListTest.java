package ua.artcode.week1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CardListTest {

    private CardList cardList;
    private FlashCard card;
    private FlashCard nullCard;

    @Before
    public void setUp() {
        cardList = new CardList();
        card = new FlashCard(0, "a", "b");
        nullCard = null;
    }

    @Test
    public void addCard() {
        assertEquals(true, cardList.addCard(card));
    }

    @Test
    public void addNullCard() {
        assertEquals(false, cardList.addCard(nullCard));
    }

    @Test
    public void removeExist() {
        cardList.addCard(card);
        assertEquals(true, cardList.remove(card));
    }

    @Test
    public void removeNull() {
        assertEquals(false, cardList.remove(null));
    }

    @Test
    public void removeNotExist() {
        cardList.addCard(card);
        assertEquals(false, cardList.remove(new FlashCard(-1, "a", "b")));
    }

    @Test
    public void removeByIndex() {
        cardList.addCard(card);
        cardList.addCard(card);
        cardList.addCard(card);
        assertEquals(true, cardList.remove(1));
    }

    @Test
    public void removeByIndex1() {
        assertEquals(false, cardList.remove(-1));
    }

    @Test
    public void removeByIndex2() {
        assertEquals(false, cardList.remove(Integer.MAX_VALUE));
    }

    @Test
    public void getAll() {
        FlashCard[] expected = new FlashCard[]{new FlashCard(0, "a", "b"),
                new FlashCard(1, "c", "d")};

        cardList.addCard(card);
        cardList.addCard(nullCard);
        cardList.addCard(new FlashCard(1, "c", "d"));

        assertArrayEquals(expected, cardList.getAll());
    }

    @Test
    public void getActualSize() {
        cardList.addCard(card);
        assertEquals(1, cardList.getActualSize());
    }

    @Test
    public void getActualSize1() {
        assertEquals(0, cardList.getActualSize());
    }
}