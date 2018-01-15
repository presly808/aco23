package flashCard.model;

import org.junit.Assert;
import org.junit.Test;

public class FlashCardTest {

    @Test
    public void getId() {

        FlashCard flashCard = new FlashCard(1, "A", "b");
        Assert.assertEquals(1, flashCard.getId());
    }

    @Test
    public void setId() {
        FlashCard flashCard = new FlashCard();
        flashCard.setId(1);
        Assert.assertEquals(1, flashCard.getId());
    }

    @Test
    public void getFront() {
        FlashCard flashCard = new FlashCard(1, "A", "b");
        Assert.assertEquals("A", flashCard.getFront());
    }

    @Test
    public void setFront() {
        FlashCard flashCard = new FlashCard();
        flashCard.setFront("A");
        Assert.assertEquals("A", flashCard.getFront());
    }

    @Test
    public void getBack() {
        FlashCard flashCard = new FlashCard(1, "A", "b");
        Assert.assertEquals("b", flashCard.getBack());
    }

    @Test
    public void setBack() {
        FlashCard flashCard = new FlashCard();
        flashCard.setBack("b");
        Assert.assertEquals("b", flashCard.getBack());
    }

    /*@Test
    public String toString() {
        FlashCard flashCard = new FlashCard(1, "A", "b");
        Assert.assertEquals("FlashCard id 1, front: A, back: b", flashCard.toString());
        return  flashCard.toString();
    }*/
}