package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {
        while (first.next!=null)first = first.next;
        first.next = new Node(null,val);
    }

    @Override
    public Node addToHead(Node chain, Object val) {
        Node head = new Node(chain,val);
        return head;
    }

    @Override
    public String toString(Node chain) {
        String res = "";
        Node iter = chain;
        while (iter != null) {
            res += iter.value + "->";
            iter = iter.next;
        }
        return res;
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
        while (chain != null)
        {
            count++;
            chain = chain.next;
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
        List<Object> objects = new ArrayList<>();
        while (chain != null) {
            objects.add(chain.value);
            chain = chain.next;
        }
        Object[] obj = objects.toArray();

        return obj;
    }

    @Override
    public Node reverse(Node curr) {
        Node prev = null;
        Node current = curr;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        curr = prev;
        return curr;
    }


    @Override
    public Node reverse(Node curr, Node next, Node prev) {
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr = prev;
        return curr;
    }
}
