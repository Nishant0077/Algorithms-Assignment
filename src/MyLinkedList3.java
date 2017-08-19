
import java.util.*;

public class MyLinkedList3<AnyType> implements Iterable<AnyType>
{
   private Node<AnyType> head;

   // constructor for the linked list
   public MyLinkedList3()
   {
      head = null;
   }
   
   // check if list is empty or not
   public boolean isEmpty()
   {
      return head == null;
   }
 
   // add a new node to the beginning of the list having the item passed as
   // parameter
   
   public void addFirst(AnyType item)
   {
      head = new Node<AnyType>(item, head);
   }
 
   // return the data of the head node
   // if there is no head, return null
   
   public AnyType getFirst()
   {
      if(head == null) 
    	  throw new NoSuchElementException();

      return head.data;
   }
   
   // remove the first element from the list and return its data
   // assigns the second node as the head node
   
   public AnyType removeFirst()
   {
      AnyType tmp = getFirst();
      head = head.next;
      return tmp;
   }
 
   // insert a new node at the end of the list
   
   public void addLast(AnyType item)
   {
	   // if there is no head, make a new node as the head
	   
      if( head == null)
         addFirst(item);
      
      // if there is a head, keep traversing the list until the last
      // node is found. Create a new node which would be the next node for 
      // the last node found
      
      else
      {
         Node<AnyType> tmp = head;
         
         while(tmp.next != null) 
        	 tmp = tmp.next;

         tmp.next = new Node<AnyType>(item, null);
      }
   }
   
   // return the last element in the list
   public AnyType getLast()
   {
	   // throw error if there is no head
      if(head == null) 
    	  throw new NoSuchElementException();

      Node<AnyType> tmp = head;
      
      // traverse the whole list to find the last node
      while(tmp.next != null) 
    	  tmp = tmp.next;

      // return the data of the last node
      return tmp.data;
   }

   // remove all nodes from list
   // makes the head null
   public void clear()
   {
      head = null;
   }

   // check if the given element exists in the list
   public boolean contains(AnyType x)
   {
      for(AnyType tmp : this)
         if(tmp.equals(x)) 
        	 return true;

      return false;
   }

   // returns the data of the node at the given position
   public AnyType get(int pos)
   {
      if (head == null) throw new IndexOutOfBoundsException();

      Node<AnyType> tmp = head;
      for (int k = 0; k < pos; k++) tmp = tmp.next;

      if( tmp == null) throw new IndexOutOfBoundsException();

      return tmp.data;
   }
 
   // the node class
   private static class Node<AnyType>
   {
      private AnyType data;
      private Node<AnyType> next;

      public Node(AnyType data, Node<AnyType> next)
      {
         this.data = data;
         this.next = next;
      }
   }


   // iterator for linked list
   
   public Iterator<AnyType> iterator()
   {
      return new LinkedListIterator();
   }

   
   private class LinkedListIterator  implements Iterator<AnyType>
   {
      private Node<AnyType> nextNode;

      public LinkedListIterator()
      {
         nextNode = head;
      }

      // check if a next node exists
      public boolean hasNext()
      {
         return nextNode != null;
      }

      // get the next node in the list
      public AnyType next()
      {
         if (!hasNext()) 
        	 throw new NoSuchElementException();
         
         AnyType res = nextNode.data;
         nextNode = nextNode.next;
         return res;
      }

   }

}