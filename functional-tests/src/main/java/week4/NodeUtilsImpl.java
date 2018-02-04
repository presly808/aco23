package week4;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {

    }

    @Override
    public Node addToHead(Node chain, Object val) {
        return null;
    }

    @Override
    public String toString(Node chain) {
        return null;
    }

    @Override
    public Node createNode(Object... mas) {
        return null;
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

    // 1,2,3,4,5 -> 5,4,3,2,1
    @Override
    public Node reverse(Node curr) {

        Node next = null;
        Node prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    @Override
    public Node reverse(Node curr, Node next, Node prev) {

        if(curr == null){
            return prev;
        }

        next = curr.next;
        curr.next = prev;

        return reverse(next, next, curr);
    }
}
