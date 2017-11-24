package utilities;

import exceptions.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTests
{
    @Test
    public void enqueueTest()
    {
        MyQueue<String> queue = new MyQueue();
        
        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");
        
        assertEquals("cow", queue.peek());
    }
    
    @Test
    public void dequeueTest()
    {
        MyQueue<String> queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");
        
        String objectremoved = queue.dequeue();

        assertEquals("hello", objectremoved);
    }
    
    @Test
    public void dequeueAllTest()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");
        
        queue.dequeueAll();
        
        assertEquals(0, queue.size());
    }
    
    @Test
    public void sizeTest()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");
        
        assertEquals(3, queue.size());
    }
    
    @Test
    public void isEmpty()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");

        assertEquals(false, queue.isEmpty());
    }
    
    @Test
    public void peekTest()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");

        assertEquals("cow", queue.peek());
    }
    
    @Test
    public void isFullTest()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");
        
        assertEquals(true, queue.isFull());
    }
    
    @Test
    public void equalsTest()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");

        MyQueue queue2 = new MyQueue();

        queue2.enqueue("hello");
        queue2.enqueue("cat");
        queue2.enqueue("cow");
        
        boolean result = queue.equals(queue2);
        
        
        assertEquals(true, result);
    }
    
    @Test
    public void toArrayTest()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");
        
        Object[] array = new Object[queue.size()];
        array = queue.toArray();
        
        assertEquals("cow", array[0]);
        assertEquals("cat", array[1]);
        assertEquals("hello", array[2]);
    }
    
    @Test
    public void toArrayObjectTest()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");

        Object[] array = new Object[queue.size()];
        array = queue.toArray(array);

        assertEquals("cow", array[0]);
        assertEquals("cat", array[1]);
        assertEquals("hello", array[2]);
    }
    
    @Test
    public void iteratorTest()
    {
        MyQueue queue = new MyQueue();

        queue.enqueue("hello");
        queue.enqueue("cat");
        queue.enqueue("cow");
        
        Iterator iterator = queue.iterator();
        
        Object a,b,c;


        try
        {
            a = iterator.next();
            b = iterator.next();
            c = iterator.next();
            
            assertEquals("cow", a);
            assertEquals("cat", b);
            assertEquals("hello", c);
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }

    }
    
}
