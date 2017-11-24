package utilities;

import exceptions.NoSuchElementException;

public class MyArrayList<E> implements List<E>
{
    private Object[] storage;
    private final int DEFAULT_ARRAY_SIZE = 0;
    private int size;
    private int index;

    public MyArrayList()
    {
        if (this.size < 0)
        {
            throw new IllegalArgumentException("Illegal size: " + size());
        } else
        {
            storage = new Object[DEFAULT_ARRAY_SIZE];
            this.size = DEFAULT_ARRAY_SIZE;
        }
    }

    public MyArrayList(int size)
    {
        if (this.size < 0)
        {
            throw new IllegalArgumentException("Illegal size: " + size());
        } else
        {
            storage = new Object[size];
            this.size = size;
        }
    }

    @Override
    public int size()
    {
        return this.size;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < this.size; i++)
        {
            storage[i] = null;
        }
        this.size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException
    {
        if (index < 0 || index > this.size())
        {
            throw new IndexOutOfBoundsException();
        }

        ensureCapacity(size + 1);

        System.arraycopy(storage, index, storage, index + 1, size - index);

        storage[index] = toAdd;

        this.size++;

        if (storage[this.index] != null)
        {
            this.index++;
            return true;
        } else
        {
            this.index++;
            throw new NullPointerException();
        }
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException
    {
        if (index < 0 || index > this.size())
        {
            throw new IndexOutOfBoundsException();
        }

        if (this.index == this.size)
        {
            this.size = this.size + 1;
            Object newData[] = new Object[this.size];

            for (int i = 0; i < storage.length; i++)
            {
                newData[i] = storage[i];
            }
            this.storage = newData;
        }
        storage[this.index] = toAdd;

        if (storage[this.index] != null)
        {
            this.index++;
            return true;
        } else
        {
            this.index++;
            throw new NullPointerException();
        }

    }

    @Override
    public boolean addAll(List toAdd) throws NullPointerException
    {
        for (int i = 0; i < toAdd.size(); i++)
        {
            if (toAdd.get(i) == null)
            {
                throw new NullPointerException();
            }

            this.add((E)toAdd.get(i));
        }

        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > this.size())
        {
            throw new IndexOutOfBoundsException();
        }

        return (E) storage[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index > this.size())
        {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < this.size; i++)
        {
            if (storage[i] == storage[index])
            {
                E objectRemoved = (E) storage[index];
                removeAt(index);
                return objectRemoved;
            }
        }

        return null;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (storage[i] == toRemove)
            {
                if (storage[i] == null)
                {
                    throw new NullPointerException();
                }

                E objectRemoved = (E) storage[i];
                removeAt(i);
                return objectRemoved;
            }
        }

        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException
    {
        if (index < 0 || index > this.size())
        {
            throw new IndexOutOfBoundsException();
        }

        if (this.index == this.size)
        {
            this.size = this.size + 1;
            Object newData[] = new Object[this.size];

            for (int i = 0; i < storage.length; i++)
            {
                newData[i] = storage[i];
            }
            this.storage = newData;
        }
        storage[index] = toChange;

        if (storage[index] != null)
        {
            this.index++;
            return (E) storage[index];
        } else
        {
            this.index++;
            throw new NullPointerException();
        }

    }

    @Override
    public boolean isEmpty()
    {
        if (this.size == 0)
        {
            return true;
        } else
        {
            return false;
        }

    }

    @Override
    public boolean contains(E toFind) throws NullPointerException
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (storage[i] == toFind)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException
    {
        for (int i = 0; i < this.size(); i++)
        {
            if (storage[i] == null)
            {
                throw new NullPointerException();
            }

            toHold[i] = (E)storage[i];
        }

        return (E[]) toHold;
    }

    @Override
    public E[] toArray()
    {
        return (E[])storage;
    }

    private void removeAt(int position) throws ArrayIndexOutOfBoundsException
    {

        if (position < this.size)
        {
            Object obj = storage[position];
            storage[position] = null;
            int tmp = position;
            while (tmp < (this.size - 1))
            {
                storage[tmp] = storage[tmp + 1];
                storage[tmp + 1] = null;
                tmp++;
            }
            this.index--;
            this.size--;

        } else
        {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    private void ensureCapacity(int minCapacity)
    {

        Object EMPTY_DATA[] = {};

        if (storage == EMPTY_DATA)
        {
            minCapacity = Math.max(DEFAULT_ARRAY_SIZE, minCapacity);
        }


        if (minCapacity - this.size > 0)
        {
            growCustomArrayList(minCapacity);
        }

    }

    private void growCustomArrayList(int minCapacity)
    {

        int oldCapacity = this.size;

        int newCapacity = oldCapacity + (oldCapacity / 2);

        if (newCapacity - minCapacity < 0)
        {
            newCapacity = minCapacity;
        }

        Object[] temp = new Object[newCapacity];

        for (int i = 0; i < storage.length; i++)
        {
            temp[i] = storage[i];
        }

        storage = temp;

    }


    @Override
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
            if(count < storage.length)
            {
                return true;
            }else
            {
                return false;
            }
        }
        
        @Override
        public E next() throws NoSuchElementException
        {
            int a = count;
            ++count;
            return (E)storage[a];
            
        }
    }

}
