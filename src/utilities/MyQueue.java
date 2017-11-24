package utilities;


import exceptions.NoSuchElementException;

public class MyQueue<E>
{
    public DLL<E> dll;
    private int size;
    
    public MyQueue()
    {
        dll = new DLL<E>();
        this.size = dll.size();
        
    }
    
    public void enqueue(E item)
    {
        dll.addFront(item);
        size = dll.size();
    }
    
    public E dequeue()
    {
        E a = dll.removeRear();
        size = dll.size();
        
        return a;
    }
    
    public void dequeueAll()
    {
        dll.clear();
        size = dll.size();
    }
    
    public int size()
    {
        return this.size;
    }
    
    public boolean isEmpty()
    {
       return dll.isEmpty();
    }
    
    public E peek()
    {
        return dll.getHeadData();
    }
    
    public boolean isFull()
    {
        if(! dll.isEmpty())
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public boolean equals(MyQueue<E> other)
    {
        if (this == other) return true;
        if (this == null || other == null) return false;
        if (this.size() != other.size()) return false;
        
        Iterator iterator = other.dll.iterator();
        Iterator iterator2 = this.iterator();
        
        while(iterator.hasNext())
        {
            try
            {
                Object object = iterator.next();
                Object object2 = iterator2.next();
                
                if(!object.equals(object2))
                {
                    return false;
                }
                
            } catch (NoSuchElementException e)
            {
                e.printStackTrace();
            }
        }
        
        return true;
    }
    
    public E[] toArray()
    {
        return dll.toArray();
    }

    public E[] toArray(E[] toHold)
    {
        return dll.toArray(toHold);
    }
    
    public Iterator<E> iterator()
    {
        return dll.iterator();
    }
    
    
}
