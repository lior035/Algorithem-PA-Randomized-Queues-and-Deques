import java.lang.*;
import java.util.*;

public class Deque<Item> implements Iterable<Item>
{
   private Node pre; //sential node
   private Node post; // sential node
   private int size;
   
   private class Node
   {
       Item data;
       Node next;
       Node prev;
   }
   
   public Deque()              
   {
       // construct an empty deque (using sential nodes)
       
       pre = new Node ();
       post = new Node ();
       
       size = 0;
       
       pre.next = post;
       post.prev = pre;
   }
   
   public boolean isEmpty()  
   {
       // is the deque empty?
      if (this.size == 0)
          return true;
      return false;
   }
   
   public int size()                  
   {
       // return the number of items on the deque
       return size;
   }
   
   public void addFirst(Item item)  throws java.lang.NullPointerException
   {
       // insert the item at the front
      
       //check item is not null - throw exeption if it is:
       if (item == null)
           throw new java.lang.NullPointerException ();
       
       else
       {
           Node oldFirst = pre.next;
           
           Node first = new Node ();
           first.data = item;
           first.prev = pre;
           first.next = oldFirst;
           
           pre.next = first;
           oldFirst.prev = first;
           
           size++;
       }
   }
   
   public void addLast(Item item)  throws java.lang.NullPointerException   
   {
       // insert the item at the end
       
       //check item is not null - throw exeption if it is:
       if (item == null)
           throw new java.lang.NullPointerException ();
       
       else 
       {
           Node oldLast = post.prev;
           
           Node last = new Node ();
           last.data = item;
           last.prev = oldLast;
           last.next = post;
           
           post.prev = last;
           oldLast.next = last;
           
           size++;
       }
   }
   
   public Item removeFirst() throws java.util.NoSuchElementException
   {
       // delete and return the item at the front
       if (this.isEmpty())
           throw new java.util.NoSuchElementException ();
       
       else
       {
           Node oldFirst = pre.next;
           
           Node newFirst = oldFirst.next;
           Item ret = oldFirst.data;
           newFirst.prev = pre;
           pre.next = newFirst;
           oldFirst.next = null;
           oldFirst.prev = null;
           
           size--;
           
           return ret;
       }
   }
   
   public Item removeLast() throws java.util.NoSuchElementException    
   {
       // delete and return the item at the end
        if (this.isEmpty())
           throw new java.util.NoSuchElementException ();
       
        else
        {
            Node oldLast = post.prev;
            
            Node newLast = oldLast.prev;
            Item ret = oldLast.data;
            newLast.next = post;
            post.prev = newLast;
            oldLast.prev = null;
            oldLast.next = null;
            
            size--;
            
            return ret;
        }
   }
   
    @Override
   public Iterator<Item> iterator() 
   {
       // return an iterator over items in order from front to end
       return new DequeIterator();
   }
   
   private class DequeIterator implements Iterator<Item> 
   {
        private Node current = pre.next;
        private int index = 0;
        
        @Override
        public boolean hasNext() 
        {
            if (index<size)
                return true;
            return false;
        }

        @Override
        public Item next() throws  java.util.NoSuchElementException
        {
            if (!(this.hasNext()))
                throw new java.util.NoSuchElementException ();
            else
            {
                Item item = current.data;
                current = current.next; 
                index++;
                return item;
            }
        }

        @Override
        public void remove() throws java.lang.UnsupportedOperationException
        {
            throw new java.lang.UnsupportedOperationException();
        }
   }
}