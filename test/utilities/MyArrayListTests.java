package utilities;

import exceptions.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.*;


public class MyArrayListTests
{
    @Test
    public void sizeMyArrayListConstructorTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        int actualSize = myArrayList.size();

        //verify
        int expectedDefaultSize = 0;

        assertEquals(expectedDefaultSize, actualSize);
    }

    @Test
    public void sizeCustomMyArrayListConstructorTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(33);
        int actualSize = myArrayList.size();

        //verify
        int expectedSize = 33;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void sizeTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(33);
        int actualSize = myArrayList.size();

        //verify
        int expectedSize = 33;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        int actualSize = myArrayList.size();

        //verify
        int expectedSize = 6;

        assertEquals(expectedSize, actualSize);

        //exercise
        MyArrayList<String> myArrayList2 = new MyArrayList<String>();
        boolean isAdded1 = myArrayList2.add("hello");
        boolean isAdded2 = myArrayList2.add("hello");
        boolean isAdded3 = myArrayList2.add("hello");
        boolean isAdded4 = myArrayList2.add("hello");
        boolean isAdded5 = myArrayList2.add("hello");
        boolean isAdded6 = myArrayList2.add("hello");
        boolean isAdded7 = myArrayList2.add("hello");
        boolean isAdded8 = myArrayList2.add("hello");
        int actualSize2 = myArrayList2.size();

        //verify
        int expectedSize2 = 8;
        boolean expectedIsAdded1 = true;
        boolean expectedIsAdded2 = true;
        boolean expectedIsAdded3 = true;
        boolean expectedIsAdded4 = true;

        assertEquals(expectedIsAdded1, isAdded1);
        assertEquals(expectedIsAdded2, isAdded2);
        assertEquals(expectedIsAdded3, isAdded3);
        assertEquals(expectedIsAdded4, isAdded4);
        assertEquals(expectedSize2, actualSize2);

        //exercise
        MyArrayList<Integer> myArrayList3 = new MyArrayList<Integer>(3);
        myArrayList3.add(1);
        myArrayList3.add(2);
        myArrayList3.add(3);
        int actualSize3 = myArrayList3.size();

        //verify
        int expectedSize3 = 3;

        assertEquals(expectedSize3, actualSize3);

    }

    @Test
    public void setTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);

        int a = myArrayList.set(4, 777);

        //verify
        int expected = 777;

        assertEquals(expected, a);

    }

    @Test
    public void isEmptyTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();

        myArrayList2.add(5);

        boolean isEmptyActual = myArrayList.isEmpty();
        boolean isEmptyActual2 = myArrayList2.isEmpty();

        //verify
        boolean expected = true;
        boolean expected2 = false;

        assertEquals(expected, isEmptyActual);
        assertEquals(expected2, isEmptyActual2);
    }

    @Test
    public void getTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<>(3);
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(2);

        int actual = myArrayList.get(1);

        //verify
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void removeIndexTest()
    {
        //exercise
        MyArrayList<String> myArrayList = new MyArrayList<>(3);

        myArrayList.add("cat");
        myArrayList.add("dog");
        myArrayList.add("cow");

        String objectRemovedActual = myArrayList.remove(1);
        int sizeActual = myArrayList.size();

        //verify

        String expected = "dog";
        int sizeExpected = 2;

        assertEquals(expected, objectRemovedActual);
        assertEquals(sizeExpected, sizeActual);
    }

    @Test
    public void removeObjectTest()
    {
        //exercise
        MyArrayList<String> myArrayList = new MyArrayList<>(3);

        myArrayList.add("cat");
        myArrayList.add("dog");
        myArrayList.add("cow");

        String objectRemovedActual = myArrayList.remove("dog");
        int sizeActual = myArrayList.size();

        //verify

        String expected = "dog";
        int sizeExpected = 2;

        assertEquals(expected, objectRemovedActual);
        assertEquals(sizeExpected, sizeActual);
    }

    @Test
    public void clearTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        int actualBefore = myArrayList.size();
        int expectedBefore = 3;

        myArrayList.clear();

        int actualAfter = myArrayList.size();
        int expectedAfter = 0;


        assertEquals(expectedBefore, actualBefore);
        assertEquals(expectedAfter, actualAfter);

    }

    @Test
    public void addIndexTest()
    {
        //exercise
        MyArrayList<String> myArrayList = new MyArrayList<>(3);

        myArrayList.add("cat");
        myArrayList.add("dog");
        myArrayList.add("cow");

        myArrayList.add(2, "hippo");

        String actual = myArrayList.get(2);

        //verify
        String expected = "hippo";

        assertEquals(expected, actual);

    }

    @Test
    public void addAllTest()
    {
        //exercise
        MyArrayList<String> myArrayList = new MyArrayList<>();


        MyArrayList<String> myArrayList2 = new MyArrayList<>();

        myArrayList2.add("cat");
        myArrayList2.add("dog");
        myArrayList2.add("cow");

        boolean actual = myArrayList.addAll(myArrayList2);

        //verify
        boolean expected = true;

        assertEquals(expected, actual);

    }

    @Test
    public void containsTest()
    {
        //exercise
        MyArrayList<String> myArrayList1 = new MyArrayList<>();

        myArrayList1.add("cat");
        myArrayList1.add("dog");
        myArrayList1.add("cow");

        boolean actual = myArrayList1.contains("dog");

        //verify
        boolean expected = true;

        assertEquals(expected, actual);
    }
    
    @Test
    public void toArrayObjectTest()
    {
        //exercise
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        
        
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(5);

        Integer list2[] = new Integer[myArrayList.size()];
        
        list2 = myArrayList.toArray(list2);
        
        //verify
        
        assertEquals(myArrayList.get(0), list2[0]);
        assertEquals(myArrayList.get(1), list2[1]);
        assertEquals(myArrayList.get(2), list2[2]);
        assertEquals(myArrayList.get(3), list2[3]);
        
    }
    
    @Test
    public void toArrayTest()
    {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();


        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(5);

        Object list2[] = new Integer[myArrayList.size()];
        
        list2 = myArrayList.toArray();

        assertEquals(myArrayList.get(0), list2[0]);
        assertEquals(myArrayList.get(1), list2[1]);
        assertEquals(myArrayList.get(2), list2[2]);
        assertEquals(myArrayList.get(3), list2[3]);
    }
    
    @Test 
    public void iteratorTest()
    {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(5);
        
        Iterator<Integer> iterator = myArrayList.iterator();


        try
        {
            int a = iterator.next();
            int b = iterator.next();
            int c = iterator.next();
            int d = iterator.next();
            
            int expect1 = 1;
            int expect2 = 2;
            int expect3 = 3;
            int expect5 = 5;
            
            assertEquals(expect1,a);
            assertEquals(expect2,b);
            assertEquals(expect3,c);
            assertEquals(expect5,d);
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }
}
