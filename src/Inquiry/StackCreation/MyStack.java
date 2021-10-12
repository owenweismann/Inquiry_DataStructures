package Inquiry.StackCreation;

/**
 * Owen Weismann
 * 9/13/21
 *
 * class MyStack realizes the List interface
 * but only implements methods that allow
 * stack like behavior
 *
 * A stack only allows elements to be added at the top
 * A stack only allows the current top element to be removed
 *
 *
 */

public class MyStack implements Stack_ListInterface {
    private Object[] stack;
    private int numElements;
    private int capacity;

    public MyStack() {
        this.stack = new Object[4];
        this.capacity = this.stack.length;
        this.numElements = 0;
    }
    public boolean add (Object element){ // Linear O(n) when resize, otherwise Constant
        if (this.numElements < this.capacity) {
            if (this.numElements==0) {
                this.stack[0] = element;
                numElements++;
                return true;
            }
            this.stack[this.numElements] = element;
            numElements++;
            return true;
        } else {
            this.capacity*=2;
            Object[] subStack = new Object[this.capacity];
            for (int i = 0; i < this.stack.length; i++) {
                subStack[i] = this.stack[i];
            }
            this.stack = subStack;
            this.stack[this.numElements] = element;
            numElements++;
            return true;
        }
    }
    public void add (int index, Object element){ // Constant
        throw new IllegalArgumentException("The add method takes an object only, not an Integer index value");
    }
    public void clear (){ // Constant
        this.stack = new Object[4];
        this.capacity = 4;
        this.numElements = 0;
    }
    public boolean contains (Object element){ // Constant
        throw new IllegalArgumentException("This method is not accessible by the stack class");
    }
    public Object get (int index) { // Constant
        if (index != 0)
            throw new IllegalArgumentException("Only the top index of the stack can be accessed");
        else if (this.stack[0] == null)
            throw new IllegalArgumentException("There are currently no objects in the stack");
        return this.stack[this.numElements-1];
    }
    public int indexOf (Object element){ // Constant
        throw new UnsupportedOperationException("This method is not accessible by the stack class");
    }
    public int lastIndexOf (Object element){ // Constant
        throw new UnsupportedOperationException("This method is not accessible by the stack class");
    }
    public boolean remove (Object element){ // Constant
        throw new UnsupportedOperationException("The remove method takes an Integer index rather than an object");
    }
    public Object remove (int index){ // Constant
        if (this.numElements == 0)
            throw new UnsupportedOperationException("The stack does not contain any objects to remove");
        if (index == 0) {
            Object holder = this.stack[numElements-1];
            this.stack[numElements-1] = null;
            this.numElements-=1;
            return holder;
        } else
            throw new IllegalArgumentException("Only elements in index 0 can be removed from the stack");
    }
    public Object set (int index, Object element){ // Constant
        throw new IllegalArgumentException("This method is not accessible by the stack class");
    }
    public int size (){ // Constant
        return this.numElements;
    }

    @Override
    public String toString() { // Linear O(n)
        String return_str = "[";
        if (this.numElements == 1) {
            return "[" + this.stack[0] + "]";
        } else if (this.numElements == 0) {
            return "[]";
        }
        for (int i = this.numElements-1; i > 0; i--) {
            return_str += (this.stack[i]);
            if (i != 1) {
                return_str += ",";
            }
        }
        return (return_str + this.stack[0] + "]");
    }
}
