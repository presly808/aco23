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

}
