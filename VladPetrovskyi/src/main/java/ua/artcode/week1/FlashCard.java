package ua.artcode.week1;

public class FlashCard {

    private int id;
    private String front;
    private String back;

    public FlashCard(int id, String front, String back) {
        this.back = back;
        this.front = front;
        this.id = id;
    }


    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public int getId() {
        return id;
    }

    public String convertFlashCard() {
        return String.format("id %s, front %s, back %s",
                id, front, back);
    }
}
