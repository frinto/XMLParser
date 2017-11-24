package utilities;

import exceptions.NoSuchElementException;

public class DLL<E> implements List<E>
{
    private DLLNode head;
    private int size;

    public DLLNode getHead()
    {
        return head;
    }

    public E getHeadData()
    {
        return (E) head.getData();
    }

    public int getSize()
    {
        return size;
    }

    public DLL()
    {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size()
    {
        return this.size;
    }

    @Override
    public void clear()
    {
        head = null;
        this.size = 0;
    }

    public void addFront(E data)
    {
        if (head == null)
        {
            head = new DLLNode(null, data, null);
        } else
        {
            DLLNode newNode = new DLLNode(null, data, head);
            head.previous = newNode;
            head = newNode;
        }
        this.size++;

    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException
    {
        if (head == null) return false;

        if (index < 1 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        DLLNode current = head;
        int i = 1;
        while (i < index)
        {
            current = current.next;
            i++;
        }

        if (current.previous == null)
        {
            DLLNode newNode = new DLLNode(null, toAdd, current);
            current.previous = newNode;
            head = newNode;
        } else
        {
            DLLNode newNode = new DLLNode(current.previous, toAdd, current);
            current.previous.next = newNode;
            current.previous = newNode;
        }
        size++;

        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException
    {
        if (head == null)
        {
            head = new DLLNode(null, toAdd, null);
            this.size++;
            return true;
        } else
        {
            DLLNode current = head;
            while (current.next != null)
            {
                current = current.next;

            }
            DLLNode newNode = new DLLNode(current, toAdd, null);
            current.next = newNode;
            this.size++;
            return true;
        }

    }

    @Override
    public boolean addAll(List<? extends E> toAdd) throws NullPointerException
    {
       for(int i = 0 ; i < toAdd.size(); i++)
       {
           if (head == null)
           {
               head = new DLLNode(null, toAdd.get(i), null);
               this.size++;
               
           } else
           {
               DLLNode current = head;
               while (current.next != null)
               {
                   current = current.next;

               }
               DLLNode newNode = new DLLNode(current, toAdd.get(i), null);
               current.next = newNode;
               this.size++;
           }
       }
       return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException
    {
        if (head == null) return null;

        if (index < 1 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        DLLNode current = head;
        int i = 1;

        while (i < index)
        {
            current = current.next;
            i++;
        }

        DLLNode temp = current;
        
        return (E) temp.getData();
    }

    public void removeFront()
    {
        if (head == null)
        {
            return;
        }
        head = head.next;
        head.previous = null;
        this.size--;
    }

    public E removeRear()
    {
        if (head == null) return null;

        if (head.next == null)
        {
            head = null;
            this.size--;
            return null;
        }

        DLLNode current = head;
        while (current.next.next != null)
        {
            current = current.next;
        }
        DLLNode temp = current.next;
        current.next = null;
        this.size--;
        return (E) temp.getData();
    }


    @Override
    public E remove(int index) throws IndexOutOfBoundsException
    {
        if (head == null) return null;

        if (index < 1 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }

        DLLNode current = head;
        int i = 1;

        while (i < index)
        {
            current = current.next;
            i++;
        }

        DLLNode temp = current;

        if (current.next == null)
        {
            current.previous.next = null;
        } else if (current.previous == null)
        {
            current = current.next;
            current.previous = null;
            head = current;
        } else
        {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        size--;

        return (E) temp.getData();
    }

    @Override
    public E remove(E toRemove) throws NullPointerException
    {

        if (head == null) return null;

        DLLNode current = head;

        for (current = head; current != null; current = current.next)
        {

            if (current.getData() == toRemove)
            {
                DLLNode found = current;

                if (current.previous == null)
                {
                    head = current.next;
                } else if (current.next == null)
                {
                    current.previous.next = null;
                } else
                {
                    current.previous.next = current.next;

                    current.next.previous = current.previous;
                }
                this.size--;
                return (E) found.getData();
            }
        }

        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException
    {
        E previouslyAtIndex = get(index);
        remove(index);
        add(index, toChange);
        
        return previouslyAtIndex;
    }

    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException
    {
        DLLNode temp = head.next;
        while(temp.next != null){
            if(temp.getData().equals(toFind))
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException
    {
        DLLNode temp = head;
        int currentIndex = 0;

        while (currentIndex < size) {
            E a = (E)temp.getData();
            toHold[currentIndex] = a;
            currentIndex++;
            temp = temp.next;
        }
        return (E[])toHold;
    }

    @Override
    public E[] toArray()
    {
        Object[] result = new Object[size];

        DLLNode temp = head;
        int currentIndex = 0;

        while (currentIndex < size) {
            Object a = temp.getData();
            result[currentIndex] = a;
            currentIndex++;
            temp = temp.next;
        }
        return (E[])result;
        
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iter();
    }
    

    private class Iter implements Iterator<E>
    {
        private DLLNode current  = head;  // the node that is returned by next()
        private DLLNode lastAccessed = null;      // the last node to be returned by prev() or next()
        // reset to null upon intervening remove() or add()
        private int index = 0;
        
        @Override
        public boolean hasNext()
        {
            return index < size;
        }

        @Override
        public E next() throws NoSuchElementException
        {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            E item = (E)current.getData();
            current = current.next;
            index++;
            return item;
        }
    }
}
