package utilities;

import exceptions.NoSuchElementException;


public class MyStack<E>
{
    public MyArrayList<E> myArrayList;
    private int size;

    public MyStack()
    {
        myArrayList = new MyArrayList<E>();
        this.size = myArrayList.size();
    }

    public void clear()
    {
        myArrayList.clear();
        this.size = myArrayList.size();
    }

    public int size()
    {
        return this.size;
    }

    public boolean isFull()
    {
        if (!myArrayList.isEmpty())
        {
            return true;
        }
        return false;
    }

    public boolean isEmpty()
    {
        if (myArrayList.isEmpty())
        {
            return true;
        }
        return false;
    }


    public void push(E item)
    {
        myArrayList.add(item);
        this.size = myArrayList.size();
    }

    public E pop()
    {
        E item = null;
        if (!myArrayList.isEmpty())
        {
            item = myArrayList.remove((myArrayList.size() - 1));
        }

        this.size = myArrayList.size();
        return (E) item;
    }

    public E peek()
    {
        E item = null;
        if (!myArrayList.isEmpty())
        {
            item = myArrayList.get((myArrayList.size() - 1));
        }

        return (E) item;
    }

    E search(E object)
    {
        if (myArrayList.contains(object))
        {
            return object;
        }
        return null;
    }

    public boolean contains(E object)
    {
        if (myArrayList.contains(object))
        {
            return true;
        }
        return false;
    }

    public E[] toArray()
    {
        return myArrayList.toArray();
    }

    public E[] toArray(E[] toHold)
    {
        return myArrayList.toArray(toHold);
    }


    public boolean equals(MyStack<E> other) {
        if (this == other) return true;
        if (this == null || other == null) return false;
        if (this.size() != other.size()) return false;

        for(int i=0; i < this.size; i++) {
            if(!myArrayList.get(i).equals(other.myArrayList.get(i)) ) {
                return false;
            }
        }
        return true;
    }

    public Iterator<E> iterator()
    {
        return new Iter();
    }

    private class Iter implements Iterator<E>
    {
        private int count = 0;

        @Override
        public boolean hasNext()
        {
            if (count < myArrayList.size())
            {
                return true;
            } else
            {
                return false;
            }
        }

        @Override
        public E next() throws NoSuchElementException
        {
            int a = count;
            ++count;
            return (E) myArrayList.get(a);
        }
    }

}
