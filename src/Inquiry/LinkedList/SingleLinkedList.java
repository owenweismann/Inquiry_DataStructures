package Inquiry.LinkedList;
/** @author Owen Weismann
 * @version 9/28/21
 *
 * Creates a linked list storage system
 * This system creates a connected storage interface
 * without drawbacks such as resizing and adjusting entire
 * structure for add and remove functions
 *
 */
public class SingleLinkedList implements LinkedList_ListInterface {
    private Node front;
    private int numElements;

    public SingleLinkedList() {
        front = null;
        numElements = 0;
    }

    /**
     * This method adds a value given, and returns whether it was successful
     * @param element
     * @return success
     */
    public boolean add(Object element) {
        if (numElements == 0) {
            front = new Node(element);
        } else {
            Node ptr = front;
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            ptr.setNext(new Node(element));
        }
        numElements++;
        return true;
    }

    /**
     * This methods adds a value at a supplied index,
     * refiguring the links as required
     * @param index
     * @param element
     */
    public void add(int index, Object element) {
        if (index > numElements) {
            throw new IndexOutOfBoundsException("This index does not exist");
        } else if (index == 0) {
            if (front != null) {
                Node next = front;
                front.setNext(next);
                front.setValue(element);
            } else {
                front = new Node();
                front.setValue(element);
            }
            numElements++;
        } else {
            Node prev = nodeBeforeIndex(index);
            if (index == numElements) {
                Node end = new Node();
                end.setValue(element);
                prev.setNext(end);
            } else {
                Node n = new Node();
                n.setValue(element);
                n.setNext(prev.getNext());
                prev.setNext(n);
            }
            numElements++;
        }
    }

    /**
     * This method clears the linked list by disconnecting the front Node,
     * effectively removing all connection to the other Nodes previously
     * created, as well as resetting the numElements counter
     */
    public void clear() {
            numElements = 0;
            front = null;
    }

    public boolean contains(Object element) {
        if (numElements == 0) {
            return false;
        }
        Node ptr = front;
        while (ptr.getNext() != null) {
            if (ptr.getValue().equals(element)) {
                return true;
            }
            ptr = ptr.getNext();
        }
        if (ptr.getValue().equals(element)) {
            return true;
        } else return false;
    }
    public Object get(int index) {
        if (numElements == 0) {
            throw new IndexOutOfBoundsException("This LinkedList does not have any elements to 'get'");
        } else if (numElements == 1) {
            if (index == 0) {
                return front.getValue();
            } else throw new IndexOutOfBoundsException("The called index does not exist in this LinkedList");
        } else {
            int counter = 0;
            Node ptr = front;
            while (ptr.getNext() != null) {
                if (counter == index) {
                    return ptr.getValue();
                } else {
                    ptr = ptr.getNext();
                    counter++;
                }
            }
            if (counter == index) {
                return ptr.getValue();
            } else throw new IndexOutOfBoundsException("The called index does not exist in this LinkedList");
        }
    }
    public int indexOf(Object element) {
        if (numElements == 0) {
            return -1;
        } else if (numElements == 1) {
            if (front.getValue().equals(element)) {
                return 0;
            } else return -1;
        } else {
            int counter = 0;
            Node ptr = front;
            while (ptr.getNext() != null) {
                if (ptr.getValue().equals(element)) {
                    return counter;
                } else {
                    ptr = ptr.getNext();
                    counter++;
                }
            }
            if (ptr.getValue().equals(element)) {
                return counter;
            } else return -1;
        }
    }
    public int lastIndexOf(Object element) {
        if (numElements == 0) {
            return -1;
        } else if (numElements == 1) {
            if (front.getValue().equals(element)) {
                return 0;
            } else return -1;
        } else {
            int counter = 0;
            int return_value = counter;
            Node ptr = front;
            while (ptr.getNext() != null) {
                if (ptr.getValue().equals(element)) {
                    return_value = counter;
                }
                ptr = ptr.getNext();
                counter++;
            }
            if (ptr.getValue().equals(element)) {
                return_value = counter;
            } else if (return_value == 0){
                return -1;
            }
            return return_value;
        }
    }
    public boolean remove(Object element) {
        int foundIndex = indexOf(element);
        if (foundIndex != -1) {
            remove(foundIndex);
            return true;
        } else return false;
    }
    public Object remove(int index) {
        Object return_value = null;
        if (numElements == 0) {
            throw new IndexOutOfBoundsException("There is nothing in this LinkedList to remove");
        }
        if (index == 0) {  // handle first node
            return_value = front.getValue();
            front = front.getNext();
            numElements--;
            return return_value;
         } else {  // fact at least one node, index > 0
            Node prev = nodeBeforeIndex(index);
            Node ptr = prev.getNext();
            if (ptr.getNext() == null) {
                prev.setNext(null);
                numElements--;
                return ptr.getValue();
            } else {
                Node next = nodeBeforeIndex(index+1);
                return_value = next.getValue();
                prev.setNext(next.getNext());
                numElements--;
            }
            return return_value;
         }
    }
    public Object set(int index, Object element) {
        if (index > numElements-1) {
            throw new IndexOutOfBoundsException("This index does not exist");
        }
        Node ptr = nodeBeforeIndex(index+1);
        Object removed = ptr.getValue();
        ptr.setValue(element);
        return removed;
    }
    public int size() {
        return numElements;
    }
    public String toString() {
        if (numElements == 0){
            return "[]";
        } else if (numElements == 1) {
            return "[" + front.getValue() + "]";
        } else {
            String output = "[";
            Node ptr = front;
            output += ptr.getValue();
            ptr = ptr.getNext();
            while (ptr.getNext() != null) {
                output += ", " + ptr.getValue();
                ptr = ptr.getNext();
            }
            output += ", " + ptr.getValue();
            return output+"]";
        }
    }

    // pre: index > 0
    private Node nodeBeforeIndex(int index) {
        Node ptr = front;
        int counter = 0;
        while (ptr.getNext() != null) {
            if (counter == index-1) {
                return ptr;
            }
            ptr = ptr.getNext();
            counter++;
        }
        return ptr;
    }
}
