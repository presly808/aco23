package week1;

import java.util.Arrays;

public class Cardlist {

    private int size;
    private int index;
    private Flashcard[] flashcards;

    public Cardlist(){

        flashcards = new Flashcard[5];
    }

    public boolean addCard(Flashcard flashcard){
        if (flashcard == null){
            return false;
        }
        if (size == flashcards.length){
            return false;
        }
        flashcards[size++] = flashcard;
        return true;
    }



    public boolean remove (Flashcard flashcard, int index){
        if (flashcard == null){
            return false;
        }
        index = -1;
        for (int i = 0; i <flashcards.length - 1 ; i++) {
            if (flashcards[i].equals(flashcard)) {
                index++;
                break;
            }
        }
        flashcards[index] = null;
        return  true;
    }

    public int getNewSize(){
        int newSize = 0;
        for (Flashcard flashcard : flashcards){
            if (flashcard != null){
                newSize++;
            }
        }
        return newSize;
    }

    public Flashcard[] getAll (int size){
        Flashcard[] cards = new Flashcard[size];
        int index = 0;
        for (Flashcard flashcard: cards){
        if (flashcard != null){
            cards[index++] = flashcard;
        }
    }
        return cards;
}


}
