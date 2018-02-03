package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class Node {

    public Node next;
    public Object value;

    public Node() {
    }

    public Node(Node next, Object value) {
        this.next = next;
        this.value = value;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
