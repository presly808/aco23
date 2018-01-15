package ua.artcode.week1;

import java.util.Arrays;

public class CardList {

    private int size;
    private int freeIndex;
    private FlashCard[] flashCards;

    public CardList(int size) {
        this.size = size;
        flashCards = new FlashCard[size];
    }

    public CardList() {
        flashCards = new FlashCard[2];
    }

    public boolean addCard(FlashCard flashCard) {
        if (flashCard == null)
            return false;

        makeArrBigger();

        flashCards[freeIndex++] = flashCard;

        return true;
    }

    public boolean remove(FlashCard flashCard) {
        if (flashCard == null)
            return false;

        int removedIndex = -1;
        for (int i = 0; i < freeIndex; i++) {
            if (flashCards[i].equals(flashCard)) {
                removedIndex = i;
                break;
            }
        }

        if (removedIndex == -1)
            return false;

        System.arraycopy(flashCards, removedIndex + 1, flashCards, removedIndex, freeIndex - removedIndex - 1);
        freeIndex--;

        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index > freeIndex)
            return false;
        System.arraycopy(flashCards, index + 1, flashCards, index, freeIndex - index - 1);
        freeIndex--;
        return true;
    }

    public FlashCard[] getAll() {
        return Arrays.copyOf(flashCards, freeIndex);
    }

    public int getActualSize() {
        return freeIndex;
    }

    private void makeArrBigger() {
        if (freeIndex >= size) {
            FlashCard[] buf = new FlashCard[size * 2 + 1];
            System.arraycopy(flashCards, 0, buf, 0, size);
            flashCards = buf;
            size = flashCards.length;
        }
    }
}
