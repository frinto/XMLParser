package utilities;

import exceptions.NoSuchElementException;

import org.junit.Test;

import static org.junit.Assert.*;

public class DLLTests
{
    @Test
    public void addFrontTest()
    {
        //exercise
        DLL<String> dll = new DLL();
        dll.addFront("bob");

        String a = (String) dll.getHead().getData();

        dll.addFront("cat");

        String b = (String) dll.getHead().getData();
        String actual = (String) dll.getHead().next.getData();

        //verify
        String expected = "bob";

        assertEquals(expected, actual);

    }

    @Test
    public void addTest()
    {
        //exercise
        DLL<String> dll = new DLL();

        dll.add("cat");
        dll.add("dog");
        dll.add("cow");

        String a = (String) dll.getHead().getData();
        String b = (String) dll.getHead().next.getData();
        String c = (String) dll.getHead().next.next.getData();

        //verify
        String expecta = "cat";
        String expectb = "dog";
        String expectc = "cow";

        assertEquals(expecta, a);
        assertEquals(expectb, b);
        assertEquals(expectc, c);

    }

    @Test
    public void addIndexTest()
    {
        //exercise
        DLL<String> dll = new DLL();

        dll.add("cat");
        dll.add("dog");
        dll.add("cow");

        dll.add(1, "zzzzzzz");

        String a = (String) dll.getHead().getData();

        //verify
        String expected = "zzzzzzz";
        
        assertEquals(expected,a);

    }

    @Test
    public void removeFrontTest()
    {
        //exercise
        DLL<Integer> dll = new DLL();
        dll.add(1);
        dll.add(2);
        dll.add(3);

        dll.removeFront();

        int a = (Integer) dll.getHead().getData();

        //verify
        int expected = 2;

        assertEquals(expected, a);


    }

    @Test
    public void removeRearTest()
    {
        //exercise
        DLL<Integer> dll = new DLL();
        dll.add(1);
        dll.add(2);
        dll.add(3);

        dll.removeRear();

        int size = dll.size();

        //verify
        int expected = 2;

        assertEquals(expected, size);
    }
    
    @Test
    public void removeIndexTest()
    {
        //exercise
        DLL<String> dll = new DLL();

        dll.add("cat");
        dll.add("dog");
        dll.add("cow");

        String actual =  dll.remove(2);
        //String actual = (String)nodeRemoved.getData();

        String a = (String) dll.getHead().getData();

        //verify
        String removedExpected = "dog";
        String expected = "cat";

        assertEquals(expected,a);
        assertEquals(removedExpected, actual);
    }
    
    @Test
    public void removeObjectTest()
    {
        //exercise
        DLL<String> dll = new DLL();
        dll.add("cat");
        dll.add("dog");
        dll.add("spy");
        
        String actual = dll.remove("dog");
        //String actual = (String) removedNode.getData();
        
        //verify
        String expected = "dog";
        
        assertEquals(expected,actual);
    }
    
    @Test
    public void clearTest()
    {
        DLL <String> dll = new DLL();
        dll.add("cat");
        dll.add("mouse");
        dll.add("cow");
        
        dll.clear();
        
        assertEquals(null, dll.getHead());
    }
    
    @Test
    public void containsTest()
    {
        //exercise
        DLL<String> dll = new DLL();
        dll.add("dog");
        dll.add("cat");
        dll.add("foo");
        dll.add("bar");
        
        boolean actual = dll.contains("cat");
        
        //verify
        boolean expected = true;
        
        assertEquals(expected,actual);
        
    }
    
    @Test
    public void toArrayTest()
    {
        //exercise
        DLL<Integer> dll = new DLL();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        
        Object intArray[] = {};
        intArray = dll.toArray();
        
        
        int a = (int) intArray[0];
        int b = (int) intArray[1];
        int c = (int) intArray[2];
        
        //verify
        int expecteda = 1;
        int expectedb = 2;
        int expectedc = 3;
        
        assertEquals(expecteda, a);
        assertEquals(expectedb, b);
        assertEquals(expectedc, c);
    }
    
    @Test
    public void toArrayObjectTest()
    {
        //exercise
        DLL dll = new DLL();
        dll.add(1);
        dll.add(2);
        dll.add(3);

        Object intArray[] = new Object[dll.size()];
        intArray = dll.toArray(intArray);


        int a = (int) intArray[0];
        int b = (int) intArray[1];
        int c = (int) intArray[2];

        //verify
        int expecteda = 1;
        int expectedb = 2;
        int expectedc = 3;

        assertEquals(expecteda, a);
        assertEquals(expectedb, b);
        assertEquals(expectedc, c);
    }
    
    @Test
    public void addAllTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList();
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
   
        
        DLL dll = new DLL();
        
        dll.addAll(myArrayList);
        
        
        
        int a = (int)dll.getHead().getData();
        int b = (int)dll.getHead().next.getData();
        int c = (int)dll.getHead().next.next.getData();

        //verify
        
        int exa = 5;
        int exb = 6;
        int exc = 7;
        
        assertEquals(exa, a);
        assertEquals(exb, b);
        assertEquals(exc, c);
        
    }
    
    @Test
    public void getTest()
    {
        DLL<Integer> dll = new DLL();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        
        Integer b = dll.get(2);
        
        //int b = (int) a.getData();
        
        //verify
        Integer expected = 2;
        
        assertEquals(expected, b);
        
    }
    
    @Test
    public void setTest()
    {
        DLL<Integer> dll = new DLL();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        
        dll.set(2,777);
        
        int b = dll.get(2);
        //int b = (int)a.getData();
        
        //verify
        int expected = 777;
        
        assertEquals(expected,b);
    }
    
    @Test
    public void iteratorTest()
    {
        DLL<Integer> dll = new DLL();
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        
        Iterator<Integer> iterator = dll.iterator();

        try
        {
            int a = iterator.next();
            int b = iterator.next();
            int c = iterator.next();
            int d = iterator.next();
            
            
            //verify
            int exa = 1;
            int exb = 2;
            int exc = 3;
            int exd = 4;
            
            assertEquals(exa, a);
            assertEquals(exb, b);
            assertEquals(exc, c);
            assertEquals(exd, d);
            
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
        
    }

}
