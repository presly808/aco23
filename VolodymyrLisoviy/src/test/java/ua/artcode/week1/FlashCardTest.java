package ua.artcode.week1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlashCardTest {

    private FlashCard flashCard;

    @Before
    public void setUp() {
        flashCard = new FlashCard(0, "a", "b");
    }

    @Test
    public void getId() {
        assertEquals(0, flashCard.getId());
    }

    @Test
    public void setId() {
        flashCard.setId(10);
        assertEquals(10, flashCard.getId());
    }

    @Test
    public void getFront() {
        assertEquals("a", flashCard.getFront());
    }

    @Test
    public void setFront() {
        flashCard.setFront("front");
        assertEquals("front", flashCard.getFront());
    }

    @Test
    public void getBack() {
        assertEquals("b", flashCard.getBack());
    }

    @Test
    public void setBack() {
        flashCard.setBack("back");
        assertEquals("back", flashCard.getBack());
    }
}