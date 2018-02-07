package week4;

import java.util.Arrays;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImpl implements NodeUtils {

    @Override
    public void addToTail(Node first, Object val) {

        //find tail
        Node currentNode = getTail(first);

        //add node
        currentNode.next = new Node(null, val);
    }

    @Override
    public Node addToHead(Node chain, Object val) {
        return new Node(chain, val);
    }

    @Override
    public String toString(Node chain) {

        Node currentNode = chain;
        StringBuilder chainToString = new StringBuilder();

        while (currentNode.next != null) {
            chainToString.append(currentNode.value).append(", ");
            currentNode = currentNode.next;
        }

        chainToString.append(currentNode.value);

        return chainToString.toString();
    }

    @Override
    public Node createNode(Object... mas) {
        if (mas.length < 1) return null;

        Node currentNode = new Node(null, mas[0]);
        Node head = currentNode;

        for (int i = 1; i < mas.length; i++) {
            addToTail(currentNode, mas[i]);
            currentNode = currentNode.next;
        }

        return head;
    }

    @Override
    public Node createNodeR(Object... mas) {
            // условие выхода из рекурсии
        if(mas.length == 0) return null;

        return new Node(createNodeR(Arrays.copyOfRange(mas, 1, mas.length)), mas[0]);
    }

    @Override
    public int count(Node chain) {
            // условие выхода из рекурсии
        if(chain == null) return 0;

        return count(chain.next) + 1;
    }

    @Override
    public Node remove(Node chain, Object val) {
        Node currentNode = chain;

        while (currentNode.next != null) {

            if (currentNode.value.equals(val)) {
                currentNode.next = null;
                return currentNode;
            }

            currentNode = currentNode.next;
        }

        return null;
    }

    @Override
    public Object[] toArray(Node chain) {

        Object[] nodesArray = new Object[count(chain)];
        Node currentNode = chain;

        for (int i = 0; i < nodesArray.length; i++) {
            nodesArray[i] = currentNode.value;
            currentNode = currentNode.next;

        }

        return nodesArray;
    }

    public Node reverseOld(Node curr) {
//        find tail
        Node tailNode = getTail(curr);

//        set link to the head of reversed nodes
        Node pointerNode = tailNode;

//        reverse all "next" links for each node
        while (pointerNode.value != curr.value) {
            pointerNode.next = getPrevious(curr, pointerNode);
            pointerNode = pointerNode.next;
        }

        return tailNode;
    }

    private Node getPrevious(Node chain, Node toFind) {

        while (chain.next.value != toFind.value) {
            chain = chain.next;
        }

        return chain;
    }

    private Node getTail(Node chain) {
        while (chain.next != null) {
            chain = chain.next;
        }

        return chain;
    }

    @Override
    public Node reverse(Node chain) {
        Node previousNode = null;
        Node currentNode = chain;
        Node nextNode = currentNode;

        while (nextNode != null) {
            currentNode = nextNode;
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;

        }
        return currentNode;
    }

    @Override
    public Node reverse(Node chainCurr, Node chainPrev, Node chainNext) {

        chainPrev = chainCurr.next;
        chainCurr.next = chainNext;

//        условие выхода из рекурсии
        if(chainPrev == null) return chainCurr;

        return reverse(chainPrev, chainPrev.next, chainCurr);
    }
}

