package ua.artcode.week1;

import java.util.Objects;

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

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlashCard flashCard = (FlashCard) o;
        return id == flashCard.id &&
                Objects.equals(front, flashCard.front) &&
                Objects.equals(back, flashCard.back);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, front, back);
    }
}
