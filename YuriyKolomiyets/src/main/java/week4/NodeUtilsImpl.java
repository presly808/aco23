package week4;

import java.util.Arrays;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    private Node createOneNode(Object val) {
        return new Node(null, val);
    }

    @Override
    public void addToTail(Node first, Object val) {

        if (first.next == null) {
            Node newNode = createOneNode(val);
            first.next = newNode;
            return;
        }
        addToTail(first.next, val);

    }

    @Override
    public Node addToHead(Node chain, Object val) {

        Node newNode = createOneNode(val);

        if (chain == null) {
            return newNode;

        } else {
            newNode.next = chain;
            return newNode;
        }
    }

    @Override
    public String toString(Node chain) {
        if (chain == null) {
            return null;
        } else {
            return chain.value + " -> " + toString(chain.next);
        }
    }

    @Override
    public Node createNode(Object... mas) {

        Node head = createOneNode(mas[0]);

        for (int i = 1; i < mas.length; i++) {

            addToTail(head, mas[i]);
        }
        return head;
    }

    @Override
    public Node createNodeR(Object... mas) {

        if (mas.length == 0){
            return null;
        }
        Node ret = new Node(null,mas[0]);
        Node newNode = createNodeR(Arrays.copyOfRange(mas, 1, mas.length));
        ret.next = newNode;
        return ret;
    }

    @Override
    public int count(Node chain) {

        int ret = 1;

        if (chain == null) {
            return 0;
        } else if (chain.next == null) {
            return ret;
        } else {
            return ret + count(chain.next);
        }

    }

    @Override
    public Node remove(Node chain, Object val) {

        if(chain.next == null) {
            return null;

        } else if(chain.next.value.equals(val)){
            Node ret = chain.next;
            chain.next = ret.next;
            return ret;
        }
        return remove(chain, val);
    }


    @Override
    public Object[] toArray(Node chain) {

        int chainSize = count(chain);
        Object[] ret = new Object[chainSize];

        for (int i = 0; i < chainSize - 1; i++) {
            ret[i] = chain.value;
        }
        return ret;
    }


    @Override
    public Node reverse(Node curr) {

        Node prevNode = null;
        Node node = curr;

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
        /*if (curr == null) {
            return prev;
        }

        next = curr.next;
        curr.next = prev;

        return reverse(next, next, curr);*/

        curr.next = prev;
        if (next == null) {
            return curr;
        }
        return reverse(next, next.next, curr);
    }
}
