package ua.artcode.week1;

public class FlashCard {

    private int cardId;
    private String frontSide;
    private String backSide;


    public FlashCard(int cardId, String frontSide, String backSide) {
        this.cardId = cardId;
        this.frontSide = frontSide;
        this.backSide = backSide;
    }

    public FlashCard() {
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getFrontSide() {
        return frontSide;
    }

    public void setFrontSide(String frontSide) {
        this.frontSide = frontSide;
    }

    public String getBackSide() {
        return backSide;
    }

    public void setBackSide(String backSide) {
        this.backSide = backSide;
    }

    public String asString(){
        return String.format("id %s front %s, back %s ", cardId, frontSide, backSide);
    }

}
