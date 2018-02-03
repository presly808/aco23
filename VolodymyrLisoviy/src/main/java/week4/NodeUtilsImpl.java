package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {
        Node nextNode = first.next;
        Node lastNode = first;
        while (nextNode != null) {
            lastNode = nextNode;
            nextNode = nextNode.next;
        }
        lastNode.next = new Node(null, val);
    }

    @Override
    public Node addToHead(Node chain, Object val) {
        return new Node(chain, val);
    }

    @Override
    public String toString(Node chain) {
        StringBuilder sb = new StringBuilder();
        Node node = chain;
        while(node != null) {
            sb.append(node.toString()).append(" -> ");
            node = node.next;
        }
        return sb.substring(0, sb.length() - 4);
    }

    @Override
    public Node createNode(Object... mas) {
        Node first = new Node(null, mas[0]);
        final Node head  = first;

        for (int i = 1; i < mas.length; i++) {
            first.next = new Node(null, mas[i]);
            first = first.next;
        }

        return head;
    }

    @Override
    public Node createNodeR(Object... mas) {
        Node first = new Node(null, mas[mas.length - 1]);
        final Node head  = first;

        for (int i = mas.length - 2; i >= 0; i--) {
            first.next = new Node(null, mas[i]);
            first = first.next;
        }

        return head;
    }

    @Override
    public int count(Node chain) {
        int i = 0;
        Node node = chain;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    @Override
    public Node remove(Node chain, Object val) {

        return null;
    }

    @Override
    public Object[] toArray(Node chain) {
        Object[] o = new Object[count(chain)];

        Node node = chain;
        int index = 0;
        while(node != null) {
            o[index++] = node.value;
            node = node.next;
        }
        return o;
    }

    @Override
    public Node reverse(Node curr) {
        Node prevNode = curr;
        Node node = curr.next;

        while (node != null) {
            Node nextNode = node.next;
            node.next = prevNode;
            prevNode = node;
            node = nextNode;
        }

        return prevNode;
    }

    @Override
    public Node reverse(Node curr, Node next, Node prev) {
        return null;
    }
}
