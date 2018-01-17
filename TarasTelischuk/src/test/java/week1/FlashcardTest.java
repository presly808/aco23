package week1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlashcardTest {

    @Test
    public void getId(){
        Flashcard flashcard = new Flashcard();
        int expected = 0;
        int actual = flashcard.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setId(){
        Flashcard flashcard = new Flashcard();
        flashcard.setId(5);
        int expected = 5;
        int actual = flashcard.getId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFront() {
        Flashcard flashcard = new Flashcard(0,"a", "b");
        String expected = "a";
        String actual = flashcard.getFront();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setFront(){
        Flashcard flashcard = new Flashcard();
        flashcard.setFront("front");
        String expected = "front";
        String actual = flashcard.getFront();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBack(){
        Flashcard flashcard = new Flashcard();
        flashcard.setBack("b");
        String expected = "b";
        String actual = flashcard.getBack();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setBack(){
        Flashcard flashcard = new Flashcard();
        flashcard.setBack("back");
        String expected = "back";
        String actual = flashcard.getBack();
        Assert.assertEquals(expected, actual);
    }

}