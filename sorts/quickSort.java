//   ____        _      _       _____            _       
//  / __ \      (_)    | |     / ____|          | |      
// | |  | |_   _ _  ___| | __ | (___   ___  _ __| |_ ___ 
// | |  | | | | | |/ __| |/ /  \___ \ / _ \| '__| __/ __|
// | |__| | |_| | | (__|   <   ____) | (_) | |  | |_\__ \
//  \___\_\\__,_|_|\___|_|\_\ |_____/ \___/|_|   \__|___/                                                  
package sorts;

public class quickSort
{
    int first, last;
    static int[] values;
    static final int SIZE = 100000;
    static long finalCount = 0;  
    
    public quickSort(int first, int last, int[]values)
    {
        this.first = first;
        this.last = last;
        quickSort.values = values;
        quickSort(this.first, this.last);
    }
    
    static void quickSort(int first, int last)
    {
        if(first < last)
        {
            int splitPoint;
            
            splitPoint = split(first, last);
            // values[first]..values[splitPoint - 1] <= splitVal
            // values[splitPoint] = splitVal
            // values[splitPoint+1]..values[last] > splitVal
            
            quickSort(first, splitPoint - 1);
            quickSort(splitPoint + 1, last);
        }
    }
    
    
    static int split(int first, int last)
    {
        int splitVal = values[first];
        int saveF = first;
        boolean onCorrectSide;
        
        first++;
        do
        {
            onCorrectSide = true;
            while(onCorrectSide)
            {
                if(values[first] > splitVal)
                {
                    onCorrectSide = false;
                }
                else
                {
                    first++;
                    onCorrectSide = (first <= last);
                }
            }
            onCorrectSide = (first <= last);
                while(onCorrectSide)
                {
                   if(values[last] <= splitVal)
                   {
                       onCorrectSide = false;
                   }
                   else
                   {
                       last--;
                       onCorrectSide = (first <= last);
                   }
                }
                
                if(first < last)
                   {
                       swap(first, last);
                       first++;
                       last--;
                   }
        } while (first <= last);
        
        swap(saveF, last);
        return last;
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
