package ua.artcode.week1;

public class FlashCard {

    private int id;
    private String front;
    private String back;

    public FlashCard(int id, String front, String back) {
        this.id = id;
        this.front = front;
        this.back = back;
    }

    public int getId() {
        return id;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }
}
