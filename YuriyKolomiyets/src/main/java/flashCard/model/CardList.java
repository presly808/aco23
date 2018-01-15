package flashCard.model;

import java.util.Arrays;

public class CardList {

    private FlashCard[] flashCards;

    public CardList() {
    }

    public CardList(FlashCard[] flashCards) {
        this.flashCards = flashCards;
    }

    public FlashCard[] getFlashCards() {
        return flashCards;
    }

    public void setFlashCards(FlashCard[] flashCards) {
        this.flashCards = flashCards;
    }

    public void addCard(FlashCard flashCard) {
        if (flashCards[flashCards.length - 1] != null) {
            FlashCard[] newFlashcards = Arrays.copyOf(flashCards, flashCards.length + 1);
            newFlashcards[flashCards.length] = flashCard;
            flashCards = newFlashcards;
        } else {
            for (int i = 0; i < flashCards.length; i++) {
                if (flashCards[i] == null) {
                    flashCards[i] = flashCard;
                }
            }
        }
    }

    public void removeCard(FlashCard flashCardToDelete) {
        for (int i = 0; i < flashCards.length - 1; i++) {
            if (flashCards[i].getId() == flashCardToDelete.getId()) {
                flashCards[i] = null;
            }
        }
        int counter = 0;
        FlashCard[] newFlashcards = new FlashCard[flashCards.length - 1];
        for (int i = 0; i < flashCards.length - 1; i++) {
            if (flashCards[i] != null) {
                newFlashcards[counter] = flashCards[i];
                counter++;
            }
        }
        flashCards = newFlashcards;
    }
}