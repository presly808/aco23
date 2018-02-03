package week4;

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
        Node headPointer = new Node(null, null);
        Node lastPointer = headPointer;
        int count = 0;
        for (Object obj: mas) {
            lastPointer.next = new Node( null, obj);
            lastPointer = lastPointer.next;
            count++;
        }
        System.out.println("Create Node count = " + count);

        return headPointer;
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
