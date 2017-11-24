package utilities;

public class DLLNode<E>
{
    private  E data;
    public DLLNode previous;
    public DLLNode next;
    
    public DLLNode(E data)
    {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
    
    public DLLNode(DLLNode previous, E data, DLLNode next)
    {
        this.previous = previous;
        this.data = data;
        this.next = next;
        
    }
    
    public E getData()
    {
        return this.data;
    }
    
}
