package week4;

import java.util.Arrays;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {
        if (first.next == null){
            Node newNode = new Node(null,val);
            first.next = newNode;
            return;

        }
        addToTail(first.next,val);
    }

    @Override
    public Node addToHead(Node chain, Object val) {
        return new Node(chain,val);
    }

    @Override
    public String toString(Node chain) {
        StringBuilder res = new StringBuilder();
        Node iter = chain;
        while (null != iter) {
            res.append(iter.value).append("->");
            iter = iter.next;
        }
        return res.toString();
    }

    @Override
    public Node createNode(Object... mas) {
        Node head = new Node(null, mas[0]);
        Node last = head;
        for (int i = 1; i <mas.length; i++) {
            last.next = new Node(null,mas[i]);
            last = last.next;
        }
        return head;
    }

    @Override
    public Node createNodeR(Object... mas) {
        if (mas.length == 0){
            return null;
        }
        Node created = new Node(null, mas[0]);
        created.next = createNodeR(Arrays.copyOfRange(mas,1,mas.length));
        return created;
    }

    @Override
    public int count(Node chain) {
        int count = 0;
        Node node = chain;
        while (null != node)
        {
            count++;
            node = node.next;
        }
        return count;
    }

    @Override
    public Node remove(Node chain, Object val) {
        chain.value = chain.next.value;
        chain.next = chain.next.next;
        return chain;
    }

    @Override
    public Object[] toArray(Node chain) {
        int size = count(chain);
        Object[] res = new Object[size];
        for (int i = 0; i < size - 1; i++) {
            res[i] = chain.value;
        }
        return res;
    }

    @Override
    public Node reverse(Node curr) {
        Node prev = null;
        Node node = curr;
        while (node != null) {
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }


    @Override
    public Node reverse(Node curr, Node next, Node prev) {
        curr.next = prev;
        if(next == null){
            return curr;
        }
        return reverse(next,next.next,curr);
    }
}
