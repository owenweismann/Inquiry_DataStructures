package Inquiry.LinkedList;

/**
 * Write a description of class Node here.
 *
 * @author Owen Weismann
 * @version 9/28/21
 */

public class Node {
    private Object data;
    private Node link;

    public Node() {
        data = null;
        link = null;
    }
    public Node(Object element, Node nextLink) {
        data = element;
        link = nextLink;
    }
    public Node(Object element) {
        data = element;
        link = null;
    }

    public Object getValue() {
        return data;
    }
    public Node getNext() {
        return link;
    }
    public void setValue(Object replace) {
        data = replace;
    }
    public void setNext(Node next) {
        link = next;
    }
}
