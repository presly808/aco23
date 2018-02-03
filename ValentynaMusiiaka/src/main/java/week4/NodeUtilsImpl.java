package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {

        //find tail
        Node currentNode = first;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        //add node
        currentNode.next = new Node(null, val);
    }

    @Override
    public Node addToHead(Node chain, Object val) {
        return new Node(chain, val);
    }

    @Override
    public String toString(Node chain) {

        Node currentNode = chain;
        StringBuilder chainToString = new StringBuilder();

        while (currentNode.next != null) {
            chainToString.append(currentNode.value);
            chainToString.append(", ");
            currentNode = currentNode.next;
        }

        chainToString.append(currentNode.value);

        return chainToString.toString();
    }

    @Override
    public Node createNode(Object... mas) {
        if (mas.length < 1) {
            return null;
        }

        Node currentNode = new Node(null, mas[0]);
        Node head = currentNode;

        for (int i = 1; i < mas.length; i++) {
            addToTail(currentNode, mas[i]);
            currentNode = currentNode.next;
        }

        return head;
    }

    @Override
    public Node createNodeR(Object... mas) {
        return null;
    }

    @Override
    public int count(Node chain) {
        return 0;
    }

    @Override
    public Node remove(Node chain, Object val) {
        return null;
    }

    @Override
    public Object[] toArray(Node chain) {
        return new Object[0];
    }

    @Override
    public Node reverse(Node curr) {
        return null;
    }

    @Override
    public Node reverse(Node curr, Node next, Node prev) {
        return null;
    }
}
