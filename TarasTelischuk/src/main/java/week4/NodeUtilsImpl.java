package week4;

import java.util.Arrays;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {
        if(null == first.next){
            first.next = new Node(null, val);
        }
        else{
            addToTail(first.next, val);
        }

    }

    @Override
    public Node addToHead(Node chain, Object val) {
        return new Node(chain, val);
    }

    @Override
    public String toString(Node chain) {
        StringBuilder res = new StringBuilder();
        Node iter = chain;
        while(iter != null ){
            res.append(iter.value).append("->");
            iter = iter.next;
        }
        return res.toString();
    }

    @Override
    public Node createNode(Object... mas) {
       if (mas.length == 0){
            return null;
        }
        Node headPointer = new Node(null, mas[0]);
        Node lastPointer = headPointer;
        int count = 0;
        for (int i = 1; i < mas.length; i++) {
            lastPointer.next = new Node( null, mas[i]);
            lastPointer = lastPointer.next;
            count++;

        }
        System.out.println("Create Node count = " + count);

        return headPointer;
    }

    @Override
    public Node createNodeR(Object... mas) {
        if (mas == null || mas.length == 0) {
            return null;
        }
        return new Node(createNodeR(Arrays.copyOfRange(mas, 1, mas.length)), mas[0]);

    }

    @Override
    public int count(Node chain) {
        if (chain != null) {
            return count(chain.next) + 1;
        }
        return 0;
    }

    @Override
    public Node remove(Node chain, Object val) {
        if (chain.value != null){
            return new Node();
        }
        if (chain.value == val || chain.next != null){
            return new Node(chain.next.next, chain.next.value);
        }
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
