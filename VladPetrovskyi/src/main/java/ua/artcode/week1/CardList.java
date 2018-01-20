package ua.artcode.week1;

public class CardList {

    private static final int DEFAULT_CARD_SIZE = 5;
    private FlashCard[] cards;
    private int id;
    private int size;

    public CardList() {
        cards = new FlashCard[DEFAULT_CARD_SIZE];
    }

    public boolean addCard(FlashCard flashCard) {

        if (flashCard == null) {
            System.out.println("flashCard is null");
            return false;
        }

        if (size == cards.length) {
            System.out.println("card is full");
            return false;
        }

        cards[size++] = flashCard;

        return true;
    }

    public boolean remove(int id) {

        for (int i = 0; i < cards.length; i++) {
            if (cards[i].getId() == id) {
                return true;
            } else {
                System.out.println("not correct deletion");
                return false;
            }
        }

        if (cards[id] == null) {
            return false;
        } else {
            cards[id] = null;
            return true;
        }
    }

    public void getAll() {
        for (FlashCard card : cards) {
            if (card != null) {
                System.out.println(card.convertFlashCard());
                size++;
            }
        }

        /*FlashCard[] toReturn = new FlashCard[size];

        for (FlashCard card : cards) {
            if (card != null) {
                toReturn[size--] = card;
            }
        }

        return toReturn;*/
    }


   /* public FlashCard[] getCards() {
        return cards;
    }

    public void setCards(FlashCard[] cards) {
        this.cards = cards;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
