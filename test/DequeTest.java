/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import junit.framework.TestCase;

/**
 *
 * @author user
 */
public class DequeTest extends TestCase {
    
    public DequeTest(String testName) {
        super(testName);
    }

    /**
     * Test of isEmpty method, of class Deque.
     */
    public void testIsEmptyServelScenrio() 
    {
        System.out.println("Test 1 -  check isEmpty on servel scenrio");
        
        
        Deque<Integer> instance = new Deque<>();
      
        System.out.println("Test 1.1 -  check isEmpty on creation - pass if true");        
        assertTrue(instance.isEmpty()); // create new empty deque - pass only if return true
       
        System.out.println("Test 1.2 -  check isEmpty after adding element to front - pass if false");        
        instance.addFirst(4);
        assertFalse(instance.isEmpty()); // not empty - pass only if return false
        
        System.out.println("Test 1.3 -  check isEmpty after remove element from front - pass if true");        
        instance.removeFirst();
        assertTrue(instance.isEmpty()); 
        
        System.out.println("Test 1.4 -  check isEmpty after add element to last - pass if  false");        
        instance.addLast(5);
        assertFalse(instance.isEmpty()); 
        
        System.out.println("Test 1.5 -  check isEmpty after remove element from last - pass if  true");        
        instance.removeLast();
        assertTrue(instance.isEmpty()); 

        //add some elemtents front and last and removing them
        System.out.println("Test 1.6.1 -  check isEmpty after add elements to last and first and than removing them - pass if  true");        
        instance.addLast(5);
        instance.addFirst(2);
        instance.removeFirst();
        instance.removeFirst();
        assertTrue(instance.isEmpty()); 
        
        System.out.println("Test 1.6.2 -  check isEmpty after add elements to last and first and than removing them - pass if  true");        
        instance.addLast(5);
        instance.addFirst(2);
        instance.removeLast();
        instance.removeFirst();
        assertTrue(instance.isEmpty()); 
        
        System.out.println("Test 1.6.3 -  check isEmpty after add elements to last and first and than removing them - pass if  true");        
        instance.addLast(5);
        instance.addFirst(2);
        instance.removeLast();
        instance.removeLast();
        assertTrue(instance.isEmpty()); 
    }
   
    /**
     * Test of size method, of class Deque.
     */
    public void testSize()
    {
        System.out.println("Test 2 -  check size on servel scenrio");
        
        Deque<Double> instance = new Deque<>();
        int expResult = 0;
        int result = instance.size();
        
        System.out.println("Test 2.1 -  size on creation - pass if equals 0");
        assertEquals(expResult, result);
        
        System.out.println("Test 2.2 -  size after adding 2 elemnts front - pass if equals 2");
        instance.addFirst(1.1);
        instance.addFirst(1.2);
        result = instance.size();
        expResult = 2;
        assertEquals(expResult, result);
        
        System.out.println("Test 2.3 -  size after adding 2 elemnts - one front and one last  - pass if equals 4");
        instance.addFirst(1.3);
        instance.addLast(1.4);
        result = instance.size();
        expResult = 4;
        assertEquals(expResult, result);
        
        System.out.println("Test 2.4 -  size after adding 2 elemnts last  - pass if equals 6");
        instance.addLast(1.5);
        instance.addLast(1.6);
        result = instance.size();
        expResult = 6;
        assertEquals(expResult, result);
        
        System.out.println("Test 2.5 -  size after removing 3 elemnts - 2 first and 1 last  - pass if equals 3");
        instance.removeFirst();
        instance.removeLast();
        instance.removeFirst();
        result = instance.size();
        expResult = 3;
        assertEquals(expResult, result);
        
        System.out.println("Test 2.6.1 -  size after removing 3 last elemnts pass if equals 0");
        instance.removeLast();
        instance.removeLast();
        instance.removeLast();
        result = instance.size();
        expResult = 0;
        assertEquals(expResult, result);
        
        System.out.println("Test 2.6.2 -  size after add 1  elemnts and remove it from first- pass if equals 0");
        instance.addFirst(1.7);
        instance.removeFirst();
        result = instance.size();
        expResult = 0;
        assertEquals(expResult, result);
    }

    /**
     * Test of addFirst method, of class Deque.
     */
    public void testAddFirstRegular() 
    {
        Deque<String> instance = new Deque<>();
        String result;
        String item;
        
        System.out.println("Test 3 -  check addFirst on servel scenrio");
        
        System.out.println("Test 3.1 -  adding 'a' to first check if this is first");
        item = "a";
        instance.addFirst(item);
        result = instance.removeFirst();
        assertEquals (item,result);
        
        System.out.println("Test 3.2 -  adding 'a','b', 'c'  to first check if 'c' is first");
        item = "a";
        instance.addFirst(item);
        item = "b";
        instance.addFirst(item);
        item = "c";
        instance.addFirst(item);
        result = instance.removeFirst();
        assertEquals (item,result);
        
        System.out.println("Test 3.3 -  adding 'a','b' to first, and 'c'  to last check if 'b' is first");
        item = "a";
        instance.addFirst(item);
        item = "b";
        instance.addFirst(item);
        item = "c";
        instance.addLast(item);
        item = "b";
        result = instance.removeFirst();
        assertEquals (item,result);
        
    }

     public void testAddFirstException() 
    {
        try
        {
             Deque<String> instance = new Deque<>();
             String item = null;
            
             System.out.println("Test 4 -  check if addFirst throw exeption");
             instance.addFirst(item);
             fail ("java.lang.NullPointerException expected!!");
        }
        
        catch(java.lang.NullPointerException ex)
        {
        }
    }
    
    /**
     * Test of addLast method, of class Deque.
     */
    public void testAddLastRegular() 
    {
        Deque<Character> instance = new Deque<>();
        char result;
        char item;
        
        System.out.println("Test 5 -  check addLast on servel scenrio");
        
        System.out.println("Test 5.1 -  adding 'a' to last check if this is last");
        item = 'a';
        instance.addLast(item);
        result = instance.removeLast();
        assertEquals (item,result);
       
        System.out.println("Test 5.2 -  adding 'a', than 'b' to last check if 'b' is last");
        item = 'a';
        instance.addLast(item);
        item = 'b';
        instance.addLast(item);
        result = instance.removeLast();
        assertEquals (item,result);
       
        System.out.println("Test 5.3 -  adding 'a','b' to last, and 'c'  to first check if 'b' is last");
        item = 'a';
        instance.addLast(item);
        item = 'b';
        instance.addLast(item);
        item = 'c';
        instance.addFirst(item);
        item = 'b';
        result = instance.removeLast();
        assertEquals (item,result);    
    }

     public void testAddLastException() 
    {
        try
        {
             Deque<String> instance = new Deque<>();
             String item = null;
            
             System.out.println("Test 6 -  check if addLast throw exeption");
             instance.addLast(item);
             fail ("java.lang.NullPointerException expected!!");
        }
        
        catch(java.lang.NullPointerException ex)
        {
        }
    }
    
    /**
     * Test of removeFirst method, of class Deque.
     */
    public void testRemoveFirstRegular() 
    {
        Deque<Character> instance = new Deque<>();
        char result;
        char item;
        char expResult;
        
        System.out.println("Test 7 -  check removeFirst on servel scenrio");
        
        System.out.println("Test 7.1 -  insert 'a' 'b' 'c' to first ,  and remove first - 'c' is expected");
        
        item = 'a';
        instance.addFirst(item);
        item = 'b';
        instance.addFirst(item);
        item = 'c';
        instance.addFirst(item);
        
        expResult = item;
        result = instance.removeFirst();
        assertEquals(expResult, result);
        
        System.out.println("Test 7.2 -  removeFirst twice - 'a' is expected");
        result = instance.removeFirst();
        result = instance.removeFirst();;
        expResult = 'a';
        assertEquals(expResult, result);
        
        System.out.println("Test 7.3 -  insert last twice - 'a' and 'b' - 'a' is expected");
        expResult = 'a';
        item = 'a';
        instance.addLast(item);
        item = 'b';
        instance.addLast(item);
        
        result = instance.removeFirst();
        assertEquals (expResult, result);
     }
    
    public void testRemoveFirstExeption() 
    {
         try
        {
             Deque<String> instance = new Deque<>();
             String item = null;
            
             System.out.println("Test 8 -  check if removeFirst throw exeption");
             instance.removeFirst();
             fail ("java.util.NoSuchElementException expected!!");
        }
        
        catch(java.util.NoSuchElementException ex)
        {
        }
    }

    /**
     * Test of removeLast method, of class Deque.
     */
    public void testRemoveLastRegular() 
    {
        Deque<Character> instance = new Deque<>();
        char result;
        char item;
        char expResult;
        
        System.out.println("Test 9 -  check removeLast on servel scenrio");
        
        System.out.println("Test 9.1 -  insert 'a' 'b' 'c' to first ,  and remove last - 'a' is expected");
        
        item = 'a';
        instance.addFirst(item);
        item = 'b';
        instance.addFirst(item);
        item = 'c';
        instance.addFirst(item);
        
        expResult = 'a';
        result = instance.removeLast();
        assertEquals(expResult, result);
        
        System.out.println("Test 9.2 -  remove last twice - 'c' is expected");
        result = instance.removeLast();
        result = instance.removeLast();;
        expResult = 'c';
        assertEquals(expResult, result);
        
        System.out.println("Test 9.3 -  insert last twice - 'a' and 'b' - 'b' is expected");
        expResult = 'b';
        item = 'a';
        instance.addLast(item);
        item = 'b';
        instance.addLast(item);
        
        result = instance.removeLast();
        assertEquals (expResult, result);
     }

     public void testRemoveLastExeption() 
    {
         try
        {
             Deque<String> instance = new Deque<>();
             String item = null;
            
             System.out.println("Test 10 -  check if removeLast throw exeption");
             instance.removeLast();
             fail ("java.util.NoSuchElementException expected!!");
        }
        
        catch(java.util.NoSuchElementException ex)
        {
        }
    }
     
     
    public void testNAddAndRemove ()
    {
        System.out.println("Test 11 -  check if adding n elements in order to first and than removing from last - shell be in order");
             
        int n = 10;
        int i;
        Deque<Integer> instance = new Deque<>();
        
        for (i = 0; i<n; i++)
        {
            instance.addFirst(i);
        }
        
        for (i = n-1; i>=0; i--)
        {
            int exp = n-1-i;
            int result = instance.removeLast();
            assertEquals(exp,result);
        }
    }
    /**
     * Test of iterator method, of class Deque.
     */
    public void testIterator() 
    {
        System.out.println("Test 12 -  check if iterator works fine");
        Deque<Integer> instance = new Deque<>();
         int exp;
        
        instance.addFirst(3);
        instance.addLast(4);
        instance.addFirst(2);
        instance.addFirst(1);
        instance.addLast(5);
        int sum = 0;
        
        for (Integer i : instance)
        {
            for (Integer j : instance)
            {
                sum += j;
            }
            
            sum*=i;
        }
        
        exp = 4875;
        assertEquals (exp, sum);
    }
    
    public void testIteratorExeptionRemove() 
    {
        try
        {

            System.out.println("Test 13 -  check if iterator return exceotion when using remove");
            Deque<Integer> instance = new Deque<>();
            Iterator expResult = instance.iterator();
            
            expResult.remove();
            fail (" java.lang.UnsupportedOperationException expected!!");
        }
        
        catch ( java.lang.UnsupportedOperationException ex)
        {
                    
        }
    }
    
    
    public void testIteratorExeptionNoElements() 
    {
        try
        {

            System.out.println("Test 14 -  check if iterator return exceotion when using hasNext and no next exists");
            Deque<Integer> instance = new Deque<>();
            Iterator expResult = instance.iterator();
            
            expResult.next();
            fail (" java.util.NoSuchElementException expected!!");
        }
        
        catch (java.util.NoSuchElementException ex)
        {
                    
        }
    }
}
