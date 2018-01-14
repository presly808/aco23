package ua.artcode.week1;

/**
 * Created by serhii on 14.01.18.
 */
public class FlashCard {

    private String front;
    private String back;

    public FlashCard() {
    }

    public FlashCard(String front, String back) {
        this.front = front;
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}
