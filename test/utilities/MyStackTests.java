package utilities;

import exceptions.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class MyStackTests
{
    @Test
    public void constructorTest()
    {
        MyStack<String> stack = new MyStack<>();

        int size = stack.size();

        stack.push("hey");

        size = stack.size();

        assertEquals(1, size);
    }

    @Test
    public void clearTest()
    {
        MyStack<String> stack = new MyStack<>();

        int size = stack.size();

        stack.push("hey");

        size = stack.size();
        stack.clear();
        size = stack.size();

        assertEquals(0, size);
    }

    @Test
    public void sizeTest()
    {
        MyStack<String> stack = new MyStack<>();

        int size = stack.size();

        stack.push("hey");
        stack.push("hey");
        stack.push("hey");

        size = stack.size();

        assertEquals(3, size);
    }

    @Test
    public void isFullTest()
    {
        MyStack<String> stack = new MyStack<>();

        int size = stack.size();

        stack.push("hey");

        boolean actual = stack.isFull();

        assertEquals(true, actual);
    }

    @Test
    public void isEmptyTest()
    {
        MyStack<String> stack = new MyStack<>();

        int size = stack.size();

        stack.push("hey");

        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void pushTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");
        int size = stack.size();
        assertEquals(3, size);

    }

    @Test
    public void popTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");

        assertEquals("cat", stack.pop());
        assertEquals("hello", stack.pop());
        assertEquals("hey", stack.pop());
    }

    @Test
    public void peekTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");

        assertEquals("cat", stack.peek());
        stack.pop();
        assertEquals("hello", stack.peek());
        stack.pop();
        assertEquals("hey", stack.peek());
    }

    @Test
    public void searchTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");

        String actual = stack.search("hey");

        assertEquals("hey", actual);
    }

    @Test
    public void containsTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");

        boolean actual = stack.contains("hddey");

        assertEquals(false, actual);
    }

    @Test
    public void toArrayTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");

        Object object[] = new String[stack.size()];
        object = stack.toArray();

        assertEquals("hello", object[1]);
    }

    @Test
    public void toArrayObjectTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");

        String object[] = new String[stack.size()];
        object = stack.toArray(object);

        assertEquals("hello", object[1]);
    }

    @Test
    public void equalsTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");

        MyStack<String> stack2 = new MyStack<>();

        stack2.push("hey");
        stack2.push("hello");
        stack2.push("cat");

        boolean actual = stack.equals(stack2);

        assertEquals(true, actual);
    }

    @Test
    public void iteratorTest()
    {
        MyStack<String> stack = new MyStack<>();

        stack.push("hey");
        stack.push("hello");
        stack.push("cat");

        Iterator iterator = stack.iterator();


        try
        {
            Object a = iterator.next();
            Object b = iterator.next();
            Object c = iterator.next();
            
            assertEquals("hey", a);
            assertEquals("hello", b);
            assertEquals("cat", c);
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }


    }


}
