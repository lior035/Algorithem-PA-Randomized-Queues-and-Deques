public class Subset
{
   public static void main(String[] args)
   {
       //get int k>= 0 from commend line
       int k = Integer.parseInt(args[0]);
       RandomizedQueue<String> q = new RandomizedQueue<String> ();
  
       while (!StdIn.isEmpty())
       {
          String item = StdIn.readString();
          q.enqueue(item);
       }
       
       while (k!=0)
       {
           System.out.println (q.sample());
           k--;
       }
      
   }
}