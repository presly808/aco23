package ua.artcode.week1;

public class FlashCardSet {

    private static final int DEF_SIZE = 10;
    private int listId;
    private String topic;
    public FlashCard[] cards;
    private int size;


    public FlashCardSet(int listId,String topic) {
        this.listId = listId;
        this.topic = topic;
        cards = new FlashCard[DEF_SIZE];
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public boolean add(FlashCard card){
        if (card == null){
            //System.out.println("Flash Card is null");
            return false;
        }
        if (size == cards.length){
            //System.out.println("Topic is full");
            return false;
        }
        cards[size++] = card;
        return true;
    }

    public boolean remove(FlashCard[] card, int index){
        if(card[index]==null){
            //System.out.println("Flash Card is null");
            return false;
        }
        card[index] = null;
        return true;
    }

    public void showAll(){
        for (FlashCard card : cards) {
            if (card != null)
                System.out.println(card.asString());
        }
    }

}
