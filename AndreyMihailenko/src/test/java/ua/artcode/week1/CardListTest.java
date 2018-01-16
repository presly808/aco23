package ua.artcode.week1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardListTest {

    private CardList cardList;
    private FlashCard card;
    private FlashCard card1;

    @Before
    public void setUp() throws Exception {
        cardList = new CardList();
        card = new FlashCard(0, "front", "back");
        card1 = new FlashCard(2, "fr", "ba");
    }

    @Test
    public void addFlashCard() {
        assertTrue(cardList.addFlashCard(card));
    }

    @Test
    public void addNullFlashCard() {
        assertFalse(cardList.addFlashCard(null));
    }

    @Test
    public void getActualSize() {
        cardList.addFlashCard(card);
        cardList.addFlashCard(card);
        assertEquals(2, cardList.getActualSize());
    }

    @Test
    public void getActualSize1() {
        cardList.addFlashCard(card);
        cardList.addFlashCard(new FlashCard(3, "a", "b"));
        cardList.remove(card);
        assertEquals(1, cardList.getActualSize());
    }

    @Test
    public void remove() {
        cardList.addFlashCard(new FlashCard(1, "a", "b"));
        cardList.addFlashCard(card);
        assertTrue(cardList.remove(card));
    }

    @Test
    public void remove1() {
        cardList.addFlashCard(new FlashCard(1, "a", "b"));
        cardList.addFlashCard(card);
        assertFalse(cardList.remove(card1));
    }

    @Test
    public void getFlashCards() {
        FlashCard[] fine = new FlashCard[]{card, card, card};
        cardList.addFlashCard(card);
        cardList.addFlashCard(card);
        cardList.addFlashCard(null);
        cardList.addFlashCard(card);
        cardList.addFlashCard(null);
        assertArrayEquals(fine, cardList.getFlashCards(cardList.getActualSize()));
    }

}