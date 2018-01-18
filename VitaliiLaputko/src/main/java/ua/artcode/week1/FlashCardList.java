package ua.artcode.week1;

import java.util.Arrays;

public class FlashCardList {

    private int position = 0;
    private FlashCard[] cardList;

    FlashCardList() {
        cardList = new FlashCard[10];
    }

    public boolean addCardToList(FlashCard card){
        if (position == cardList.length - 1)
            cardList = Arrays.copyOf(cardList, cardList.length + 10);

        for (int i = 0; i < position; i++) {
            if (card.getId() == cardList[i].getId()){
                System.err.println("Card List already contains current card: id = " + card.getId());
                return false;
            }
        }

        cardList[position] = card;
        position++;

        System.out.format("Card with id => %s; front => %s; back => %s, - " +
                        "was added successfully on position => %d.\n",
                + card.getId(), card.getFront(), card.getBack(), position);

        return true;
    }

    public void deleteCardFromListByFrontValue(String front){
        if (position == 0) {
            System.err.println("Card list is empty!");
            return;
        }

        /*Logic for deleting last element in card list, for saving resources in case large CardList*/
        if (cardList[position-1].getFront().equals(front)) {
            deleteActionWithoutCopy(position-1);
            return;
        }

        for (int i = 1; i < position; i++) {
            if (cardList[i].getFront().equals(front)) {
                deleteAction(i);
            } else {
                System.err.println(String.format("Specified card front(%s) is absent in card list.", front));
            }
        }
    }

    public boolean deleteCardFromListById(int id){
        if (position == 0) {
            System.err.println("Card list is empty!");
            return false;
        }
        /*Logic for deleting last element in card list, for saving resources in case large CardList*/
        if (cardList[position-1].getId() == id) {
            deleteActionWithoutCopy(position-1);
            return true;
        }

        for (int i = 1; i < position; i++) {
            if (cardList[i].getId() == id) {
                deleteAction(i);
                return true;
            } else {
                System.err.println(String.format("Specified card id(%d) is absent in card list.", id));
                return false;
            }
        }
        return false;
    }

    public void printCardList(){
        if (position != 0){
            for (int i = 0; i < position; i++) {
                System.out.format("Card id => %s; card front => %s; card back => %s.\n",
                        + cardList[i].getId(), cardList[i].getFront(), cardList[i].getBack());
            }
        } else {
            System.out.println("Card list is empty!");
        }
    }

    private void deleteAction(int index){
        System.out.format("Card with id => %d (front => %s) was deleted successfully\n",
                cardList[index].getId(),
                cardList[index].getFront());

        cardList[index] = null;
        System.arraycopy(cardList, index+1, cardList, index, position-index);
        position--;
    }

    private void deleteActionWithoutCopy(int index){
        System.out.format("Card with Id => %d (front => %s) was deleted successfully.\n",
                cardList[index].getId(),
                cardList[index].getFront());

        cardList[index] = null;
        position--;
    }
}
