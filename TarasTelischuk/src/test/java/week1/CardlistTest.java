package week1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardlistTest {

    private Cardlist cardlist;
    private Flashcard flashcard;
    private Flashcard nullcard;

    @Before
    public void setUp() throws Exception {
        cardlist = new Cardlist();
        nullcard = new Flashcard(0,"front", "back");;
        flashcard = new Flashcard(3,"f", "b");
    }


    @Test
    public void addCard()  {
        assertEquals(true, cardlist.addCard(flashcard));
    }

    @Test
    public void addnullCard()  { assertEquals(false, cardlist.addCard(null));
    }

    @Test
    public void remove(){
        cardlist.addCard(flashcard);
        Assert.assertEquals(true, cardlist.remove(flashcard,0));
    }

    @Test
    public void getNewSize() {
        cardlist.addCard(flashcard);
        Assert.assertEquals(1, cardlist.getNewSize());
    }
}