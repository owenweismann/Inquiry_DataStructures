package Inquiry.StackCreation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStack_Test {

    @Test
    void add() {

    }

    @Test
    void get() {
        MyStack newStack = new MyStack();
        newStack.add("hello");
        newStack.add("world");
        newStack.add("I");
        newStack.add("am");
        assertEquals("am",newStack.get(0));
    }
    @Test
    void remove_noElements() {
        MyStack newStack = new MyStack();
        boolean success = false;
        try {
            newStack.remove(0);
        } catch (IllegalArgumentException exc){
            success = true;
        }
        assertEquals(true,success);
    }
    @Test
    void remove_oneElement() {
        MyStack newStack = new MyStack();
        newStack.add("hello");
        assertEquals("hello",newStack.remove(0));
        assertEquals("hello",newStack.remove(0));
    }
    @Test
    void remove() {
        MyStack newStack = new MyStack();
        newStack.add("hello");
        newStack.add("world");
        newStack.add("I");
        newStack.add("am");
        newStack.add("me");
        newStack.add("who");
        newStack.add("might");
        assertEquals("might",newStack.remove(0));
        assertEquals("[who,me,am,I,world,hello]",newStack.toString());
    }

    @Test
    void size() {
        MyStack newStack = new MyStack();
        assertEquals(0,newStack.size());
    }
    @Test
    void size2() {
        MyStack newStack = new MyStack();
        newStack.add("hello");
        assertEquals(1,newStack.size());
    }
    @Test
    void size3() {
        MyStack newStack = new MyStack();
        newStack.add("hello");
        newStack.add("world");
        newStack.add("I");
        newStack.add("am");
        newStack.add("me");
        newStack.add("who");
        newStack.add("might");
        newStack.add("you");
        newStack.add("be");
        assertEquals(9,newStack.size());
    }

    @Test
    void testToString() {
        MyStack newStack = new MyStack();
        newStack.add("hello");
        newStack.add("world");
        newStack.add("I");
        newStack.add("am");
        newStack.add("me");
        newStack.add("who");
        newStack.add("might");
        newStack.add("you");
        newStack.add("be");
        assertEquals("[be,you,might,who,me,am,I,world,hello]",newStack.toString());
    }
}