package ua.artcode.week1;

public class CardList {

    private int size;
    private int freeIndex;
    private FlashCard[] flashCards;

    public CardList(int size) {
        this.size = size;
        flashCards = new FlashCard[size];
    }

    public CardList() {
        flashCards = new FlashCard[10];
    }

    public boolean addFlashCard(FlashCard flashCard) {
        if (flashCard == null) {
            return false;
        }

        increaseArr();

        flashCards[freeIndex++] = flashCard;

        return true;
    }

    public void increaseArr() {
        if (freeIndex >= size) {
            FlashCard[] arr = new FlashCard[size * 2 + 1];
            System.arraycopy(flashCards, 0, arr, 0, size);
            flashCards = arr;
            size = flashCards.length;
        }
    }

    public boolean remove(FlashCard flashCard) {
        int index = -1;
        for (int i = 0; i < flashCards.length - 1; i++) {
            if (flashCards[i].equals(flashCard)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        flashCards[index] = null;
        return true;
    }

    public int getActualSize() {
        int newsize = 0;
        for (FlashCard flashCard : flashCards) {
            if (flashCard != null) {
                newsize++;
            }
        }
        return newsize;
    }

    public FlashCard[] getFlashCards(int size) {

        FlashCard[] cards = new FlashCard[size];
        int index = 0;
        for (int i = 0; i < cards.length; i++) {
            if (flashCards[i] != null) {
                cards[index++] = flashCards[i];
            }
        }
        return cards;
    }
}
