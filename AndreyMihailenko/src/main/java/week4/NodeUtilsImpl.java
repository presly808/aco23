package week4;

import java.util.Arrays;

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
        if (mas.length == 0){
            return null;
        }
        Node curr = new Node(null,mas[0]);
        Node retNode = createNodeR(Arrays.copyOfRange(mas, 1, mas.length));
        curr.next = retNode;
        return curr;
    }

    @Override
    public int count(Node chain) {
        if (chain == null){
            return 0;
        }
        return 1 + count(chain.next);
    }

    @Override
    public Node remove(Node chain, Object val) {
        Node node = chain;
        Node prev = null;

        while (node.next != null){
            if (val == node.value){
                Node forRet = node;
                prev.next = node.next;
                node = null;
                return forRet;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    @Override
    public Object[] toArray(Node chain) {
        Node node = chain;
        Object[] forRet = new Object[count(chain)];
        for (int i = 0; i < forRet.length; i++) {
            forRet[i] = node.value;
            node = node.next;
        }
        return forRet;
    }

    //
    @Override
    public Node reverse(Node curr) {
        Node node = curr;
        Node prev = curr.next;

        while (node != null){
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
            return prev;
    }


    @Override
    public Node reverse(Node curr, Node next, Node prev) {
        Node before = prev;
        curr.next = before;
        before = curr;
        if (next == null){
            return curr;
        }
        return reverse(next, next.next, before);
    }
}
