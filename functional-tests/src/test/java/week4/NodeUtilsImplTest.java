package week4;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by serhii on 03.02.18.
 */
public class NodeUtilsImplTest {

    private NodeUtils nodeUtils = new NodeUtilsImpl();

    @Test
    public void addToTail() throws Exception {

        Node node = new Node(null, 5);

        nodeUtils.addToTail(node, 6);
        nodeUtils.addToTail(node, 7);
        nodeUtils.addToTail(node, 8);

        Assert.assertThat(node.next.next.value, CoreMatchers.equalTo(7));



    }

    @Test
    public void addToHead() throws Exception {

        Node node = new Node(null, 5);

        Node head = nodeUtils.addToHead(node, 1);
        Assert.assertThat(head.value, CoreMatchers.equalTo(1));

    }

    @Test
    public void testToString() throws Exception {
        Node node = new Node(new Node(new Node(null,3), 4), 5);


        String actual = nodeUtils.toString(node);
        Assert.assertThat(actual, CoreMatchers.containsString("5"));
        Assert.assertThat(actual, CoreMatchers.containsString("4"));
        Assert.assertThat(actual, CoreMatchers.containsString("3"));


    }

    @Test
    public void createNode() throws Exception {
        Integer[] mas = {1,2,3,4,5,6};

        Node node = nodeUtils.createNode(mas);

        Assert.assertThat(node.value, CoreMatchers.equalTo(1));
        Assert.assertThat(node.next.next.next.next.next.value, CoreMatchers.equalTo(6));

    }

    @Test
    public void createNodeR() throws Exception {
        Integer[] mas = {1,2,3,4,5,6};

        Node node = nodeUtils.createNodeR(mas);

        Assert.assertThat(node.value, CoreMatchers.equalTo(1));
        Assert.assertThat(node.next.next.next.next.next.value, CoreMatchers.equalTo(6));

    }

    @Test
    public void count() throws Exception {
        Node node = new Node(new Node(new Node(null,3), 4), 5);
        Assert.assertThat(nodeUtils.count(node), CoreMatchers.equalTo(3));


    }

    @Test
    public void remove() throws Exception {
        Node node = new Node(new Node(new Node(null,3), 4), 5);
        Assert.assertThat(nodeUtils.remove(node,4).value, CoreMatchers.equalTo(4));

    }

    @Test
    public void toArray() throws Exception {
        Node node = new Node(new Node(new Node(null,3), 4), 5);
        Object[] actual = nodeUtils.toArray(node);
        Assert.assertThat(actual.length, CoreMatchers.equalTo(3));
        Assert.assertThat(actual[0], CoreMatchers.equalTo(5));

    }

    @Test
    public void reverse() throws Exception {
        Node node = new Node(new Node(new Node(null,3), 4), 5);
        Node newHead = nodeUtils.reverse(node);
        Assert.assertThat(newHead.value, CoreMatchers.equalTo(3));
        Assert.assertThat(newHead.next.next.value, CoreMatchers.equalTo(5));

    }

    @Test
    public void reverseR() throws Exception {
        Node node = new Node(new Node(new Node(null,3), 4), 5);
        Node newHead = nodeUtils.reverse(node,null,null);
        Assert.assertThat(newHead.value, CoreMatchers.equalTo(3));
        Assert.assertThat(newHead.next.next.value, CoreMatchers.equalTo(5));

    }

}