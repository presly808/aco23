package flashCard.model;

public class FlashCard {

    private int id;
    private String front;
    private String back;

    public FlashCard() {
    }

    public FlashCard(int id, String front, String back) {
        this.id = id;
        this.front = front;
        this.back = back;
    }

    @Override
    public String toString() {
        return "FlashCard " +
                "id " + id +
                ", front: '" + front + '\'' +
                ", back: '" + back + '\'';
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
}
