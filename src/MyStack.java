
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *  The {@code LinkedStack} class represents a last-in-first-out (LIFO) stack of
 *  generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a non-static nested class for 
 *  linked-list nodes. See {@link Stack} for a version that uses a static nested class.
 *  The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation,
 *  see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class MyStack<Item> implements Iterable<Item> {
    private int n;          // size of the stack
    private Node first;     // top of stack
    
    // defining what a node is for the linked list class
    // Node contains data and a pointer to the next node
    private class Node
    {
    	private Item item;
    	private Node next;
    }
    
    // constructor for MyStack. Creates an empty stack
    public MyStack()
    {
    	first = null;
    	n = 0;
    }
    

    // check if stack is empty or not. Just check if the first item is null or not
    public boolean isEmpty() 
    {
        return first == null;
    }

    // return the size of stack, i.e., the number of items in stack
    
    public int size()
    {
    	return n;
    }
      
    // function for pushing an item into the stack. 
    // we start by taking the current first item and making it "oldFirst"
    // Then we create a new node which we would be the new "first" node in the stack
    // we assign the item of the new node to be the item passed as parameter to the function \
    // and the next node for our new node would be "oldFirst"
    
    public void push(Item item)
    {
    	Node oldFirst = first;
    	first = new Node();
    	first.item = item;
    	first.next = oldFirst;
    	n++;
    }
       
   // function for pop
    // we save the item of the most recently added item in a variable. This would
    // be the item returned during the pop operation.
    // then we assign the next element in the stack as the first element and also decrement the 
    // size by 1
    // also, it returns an error if stack is empty when we perform the pop operation
    
    public Item pop() 
    {
        if (isEmpty()) 
        	throw new NoSuchElementException("Stack underflow");
        
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }
            
   // constructor for iterator for the stack
    public Iterator<Item> iterator() 
    {
        return new ListIterator();
    }

    // class for the iterator    
    private class ListIterator implements Iterator<Item> 
    {
        private Node current = first;
        
        // check if there is an item left in the list
        public boolean hasNext()  
        { 
        	return current != null;                    
        }     

        public Item next() 
        {
            if (!hasNext()) 
            	throw new NoSuchElementException();
            
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }        
    
}


