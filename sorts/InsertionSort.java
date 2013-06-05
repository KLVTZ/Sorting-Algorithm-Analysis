//  _____                     _   _             
// |_   _|                   | | (_)            
//   | |  _ __  ___  ___ _ __| |_ _  ___  _ __  
//   | | | '_ \/ __|/ _ \ '__| __| |/ _ \| '_ \ 
//  _| |_| | | \__ \  __/ |  | |_| | (_) | | | |
// |_______| |_|___/\___|_|   \__|_|\___/|_| |_|
//  / ____|          | |                        
// | (___   ___  _ __| |_                       
//  \___ \ / _ \| '__| __|                      
//  ____) | (_) | |  | |_                       
// |_____/ \___/|_|   \__|                      
                                              
                                             
package sorts;

public class insertionSort 
{
    static int[] values;
    static final int SIZE = 100000;
    static long finalCount = 0;
    
    public insertionSort(int[]values)
    {
        insertionSort.values = values;
       
        for(int count = 1; count < SIZE; count++)
        {
            insertItem(0, count);
        }
        
    }
    
    static void insertItem(int startIndex, int endIndex)
    {
        boolean finished = false;
        int current = endIndex;
        boolean moreToSearch = true;
        while(moreToSearch && !finished)
        {
            if(values[current] < values[current -1])
            {
                swap(current, current - 1);
                current--;
                moreToSearch = (current != startIndex);
            }
            else
            {
                finished = true;
            }
        }
    }
    
  static public void swap(int index1, int index2)
  // Precondition: index1 and index2 are >= 0 and < SIZE.
  //
  // Swaps the integers at locations index1 and index2 of the values array. 
  {
      int temp = values[index1];
      values[index1] = values[index2];
      values[index2] = temp;
      finalCount++;
   }
  
  public long getCounter()
  {
      return finalCount;
  }
}
