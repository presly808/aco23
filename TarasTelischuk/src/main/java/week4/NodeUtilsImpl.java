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
        for (Object obj: mas) {
            lastPointer.next = new Node( null, (int)obj + 1);
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
        if (chain.value == null){
            return null;
        }
        if (chain.value == val || chain.next != null){
            return new Node(chain.next.next, chain.next.value);
        }
        return new Node();
     }

    @Override
    public Object[] toArray(Node chain) {
        if (chain == null){
            System.out.println("Incorrect chain");
            return null;
        }
        Node lastPointer = chain;
        Object[] arr = new Object[count(chain)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lastPointer.value;
            lastPointer = lastPointer.next;
        }
        return arr;
    }

    @Override
    public Node reverse(Node curr) {
        if (curr == null){
            System.out.println("Incorrect curr");
            return null;
        }
        Node headPointer = curr;
        Node lastPointer = headPointer.next;
        while (lastPointer != null) {
            Node nextPointer = lastPointer.next;
            lastPointer.next = headPointer;
            headPointer = lastPointer;
            lastPointer = nextPointer;
        }
        return headPointer;
    }




    @Override
    public Node reverseR(Node curr, Node next, Node prev) {
        curr.next = prev;

        if (next == null){
            return curr;
        }
        return reverseR(next, next.next, curr);
    }
}
