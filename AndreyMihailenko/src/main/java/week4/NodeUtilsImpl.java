package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {
        if(first.next == null){
            first.next = new Node(null, val);
            return;
        }
        addToTail(first.next, val);
    }

    @Override
    public Node addToHead(Node chain, Object val) {
        if (chain == null){
            return new Node(null, val);
        }
        return new Node(chain, val);
    }

    @Override
    public String toString(Node chain) {
        return chain != null ?
                (chain.value.toString() + "->" + toString(chain.next)): "";
    }

    @Override
    public Node createNode(Object... mas) {
        Node node = new Node(null, mas[0]);
        Node head = node;

        for (int i = 1; i < mas.length; i++) {
            addToTail(node, mas[i]);
            node = node.next;
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
