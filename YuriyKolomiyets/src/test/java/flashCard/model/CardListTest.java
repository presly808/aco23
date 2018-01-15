package flashCard.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardListTest {


    @Test
    public void addCard() {
        CardList flashCards = new CardList(new FlashCard[1]);
        FlashCard flashCard = new FlashCard(1, "Dog", "Собака");
        flashCards.addCard(flashCard);
        Assert.assertEquals(1, flashCards.getFlashCards()[0].getId());
    }

    @Test
    public void removeCard() {
        CardList flashCards = new CardList(new FlashCard[2]);

        FlashCard flashCard1 = new FlashCard(1, "Dog", "Собака");
        FlashCard flashCard2 = new FlashCard(2, "Cat", "Кошка");

        flashCards.addCard(flashCard1);
        flashCards.addCard(flashCard2);

        flashCards.removeCard(flashCard1);
        Assert.assertEquals(null, flashCards.getFlashCards()[0]);

    }
}