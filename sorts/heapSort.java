//  _    _                     _____            _   
// | |  | |                   / ____|          | |  
// | |__| | ___  __ _ _ __   | (___   ___  _ __| |_ 
// |  __  |/ _ \/ _` | '_ \   \___ \ / _ \| '__| __|
// | |  | |  __/ (_| | |_) |  ____) | (_) | |  | |_ 
// |_|  |_|\___|\__,_| .__/  |_____/ \___/|_|   \__|
//                   | |                            
//                   |_|                           

package sorts;

public class heapSort
{
    static final int SIZE = 100000;
    static long finalCount = 0;
    static int[] values;
    
    public heapSort(int[] values)
    {
        int index;
        heapSort.values = values;
        // Convert the array of values into a heap/
        for(index = SIZE/2 - 1; index >= 0; index--)
        {
            reheapDown(values[index], index, SIZE-1);
        }
        
        // Sort the array.
        for(index = SIZE - 1; index >=1; index--)
        {
            swap(0, index);
            reheapDown(values[0], 0, index - 1);
        }
    }
    
  static void reheapDown(int item, int root, int lastIndex)
  // Precondition: Current root position is "empty".
  //
  // Inserts item into the tree and ensures shape and order properties.
  {
    int hole = root;   // current index of hole
    int newhole;       // index where hole should move to

    newhole = newHole(hole, lastIndex, item);   // find next hole
    while (newhole != hole)
    {
      values[hole] = values[newhole];      // move value up
      hole = newhole;                      // move hole down
      newhole = newHole(hole, lastIndex, item);     // find next hole
    }
    values[hole] = item;           // fill in the final hole
  }
  
  static int newHole(int hole, int lastIndex, int item)
  // If either child of hole is larger than item this returns the index
  // of the larger child; otherwise it returns the index of hole.
  {
      int left = (hole * 2) + 1;
      int right = (hole * 2) + 2;
      if (left > lastIndex)
      {
          return hole;
      }
      else
          if(left == lastIndex)
          // hole has left child only
          {
              if(item < values[left])
                  // item < left child
              {
                  return left;
              }
              else
                  // item >= left child
              {
                  return hole;
              }
          }
          else
          // hole has two children
              if(values[left] < values[right])
              // left child < right child
              {
                  if(values[right] <= item)
                      // right <= item
                  {
                      return hole;
                  }
                  else
                  // item < right child
                  {
                      return right;
                  }
              }
              else
              // left child >= right child
              {
                  if(values[left] <= item)
                  // left child <= item
                  {
                      return hole;
                  }
                  else
                  // item < left child    
                  {
                      return left;
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
