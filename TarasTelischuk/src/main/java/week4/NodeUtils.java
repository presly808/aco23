package week4;

public interface NodeUtils {


    void addToTail(Node first, Object val);

    Node addToHead(Node chain, Object val);

    String toString(Node chain);

    Node createNode(Object... mas);

    Node createNodeR(Object... mas);

    int count(Node chain);

    Node remove(Node chain, Object val);

    Object[] toArray(Node chain);

    //reverse using loop
    Node reverse(Node curr);

    //reverse usin recursion
    Node reverse(Node curr, Node next, Node prev);


}