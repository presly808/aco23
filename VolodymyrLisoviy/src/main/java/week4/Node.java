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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
