package ua.artcode.week1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlashCardTest {

    private FlashCard flashCard;

    @Before
    public void setUp() throws Exception {
        flashCard = new FlashCard(1, "front", "back");
    }

    @Test
    public void getId() {
        assertEquals(1, flashCard.getId());
    }

    @Test
    public void setId() {
        flashCard.setId(2);
        assertEquals(2, flashCard.getId());
    }

    @Test
    public void getFront() {
        assertEquals("front", flashCard.getFront());
    }

    @Test
    public void setFront() {
        flashCard.setFront("newFront");
        assertEquals("newFront", flashCard.getFront());
    }

    @Test
    public void getBack() {
        assertEquals("back", flashCard.getBack());
    }

    @Test
    public void setBack() {
        flashCard.setBack("newBack");
        assertEquals("newBack", flashCard.getBack());
    }
}