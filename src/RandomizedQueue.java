
import java.util.Iterator;

   public class RandomizedQueue<Item> implements Iterable<Item>
   {
        private int logicSize;
        private Item[] arr;
        
        public RandomizedQueue()    
        {
            // construct an empty randomized queue
            arr = (Item[]) new Object [2];
            logicSize = 0;
        }
        
        public boolean isEmpty()  
        {
            // is the queue empty?
            if (logicSize ==0)
                return true;
            
            return false;
        }
        
        public int size() 
        {
            // return the number of items on the queue
            return logicSize;
        }
        
        public void enqueue(Item item) throws java.lang.NullPointerException
        {
            //check legability of item
            if (item == null)
                throw new java.lang.NullPointerException ();
            
            // add the item
            checkAndResizeFullArray();  // check if array is full - if so , will double it size
            arr[logicSize++] = item;
             int rand = StdRandom.uniform(logicSize);
            exch (arr, rand, logicSize-1); // exchange random place with logicSize-1 (last item added)
        }
        
        public Item dequeue()   throws java.util.NoSuchElementException
        {
            //check legability of request - is queue empty?
            if (this.isEmpty())
                throw new java.util.NoSuchElementException ();
            
            // delete and return a random item
            
            //avoid loitering
            Item item = arr[--logicSize];
            arr[logicSize] = null;
            
            //after  removing - check if resize is needed (and resize if true):
            checkAndResizeQuarterFullArray();
            return item;
        }
        
        public Item sample()  throws java.util.NoSuchElementException
        {
            //check legability of request - is queue empty?
            if (this.isEmpty())
                throw new java.util.NoSuchElementException ();
           
            // return (but do not delete) a random item
            int rand = StdRandom.uniform(logicSize);
            Item item = arr[rand];
            return item;
        }
        
    @Override
        public Iterator<Item> iterator() 
        {
            // return an independent iterator over items in random order
            return new RandomizeQueueIterator ();
        }
       
        private void checkAndResizeFullArray ()
        {
            if (logicSize == this.arr.length)
                resize(2* this.arr.length);
        }
        
        private void checkAndResizeQuarterFullArray ()
        {
            if ((logicSize > 0) && (logicSize == arr.length/4))
                resize(arr.length/2);
        }
        
        private void resize(int capacity)
        {
            Item[] copy = (Item[])(new Object[capacity]);
            
            for (int i = 0; i < logicSize; i++)
                copy[i] = arr[i];
            arr = copy;
        }
        
        private void exch (Item [] arr, int i, int j)
        {
            Item swap = arr [i];
            arr[i] = arr[j];
            arr[j] = swap;
        }
        
        private class RandomizeQueueIterator implements Iterator <Item>
        {

            private  Item[] iteratorArray;
            private int elementsPassed = 0;
            
            private RandomizeQueueIterator ()
            {
                iteratorArray = (Item[])(new Object [logicSize]);
                
                for (int i = 0; i<logicSize; i++)
                    iteratorArray[i] = arr[i];
                
                StdRandom.shuffle(iteratorArray);
                
            }
            
            @Override
            public boolean hasNext()
            {
                if (elementsPassed<iteratorArray.length)
                    return true;
                return false;
            }

            @Override
            public Item next() throws   java.util.NoSuchElementException 
            {
                if (!(this.hasNext()))
                    throw new java.util.NoSuchElementException ();
                else
                {
                    Item curr = iteratorArray[elementsPassed++];
                    return curr;
                }
            }

            @Override
            public void remove() throws java.lang.UnsupportedOperationException
            {
                throw new java.lang.UnsupportedOperationException();
            }
            
        }
   }