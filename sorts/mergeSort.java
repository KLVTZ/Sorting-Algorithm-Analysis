//  __  __                        _____            _   
// |  \/  |                      / ____|          | |  
// | \  / | ___ _ __ __ _  ___  | (___   ___  _ __| |_ 
// | |\/| |/ _ \ '__/ _` |/ _ \  \___ \ / _ \| '__| __|
// | |  | |  __/ | | (_| |  __/  ____) | (_) | |  | |_ 
// |_|  |_|\___|_|  \__, |\___| |_____/ \___/|_|   \__|
//                   __/ |                             
//                  |___/                              

package sorts;

public class mergeSort 
{
    int first, last;
    static int[] values;
    static final int SIZE = 100000;
    static long finalCount = 0;   
    
    public mergeSort(int first, int last, int[]values)
    {
        this.first = first;
        this.last = last;
        mergeSort.values = values;
        mergeSort(this.first, this.last);
    }
    
    static void mergeSort(int first, int last)
    // Sorts the values array using the merge sort algorithm.        
    {
        if(first < last)
        {
            int middle = (first + last) / 2;
            mergeSort(first, middle);
            mergeSort(middle + 1, last);
            merge(first, middle, middle + 1, last);
        }
    }
    
    static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
    // Preconditions: values[leftFirst]..values[leftLast] are sorted.
    //                values[rightFirst]..values[rightLast] are sorted.
    // 
    // Sorts values[leftFirst]..values[rightLast] by merging the two subarrays.
    {
        int[] tempArray = new int [SIZE];
        int index = leftFirst;
        int saveFirst = leftFirst;
        
        while ((leftFirst <= leftLast) && (rightFirst <= rightLast))
        {
            if (values[leftFirst] < values[rightFirst])
            {
                finalCount++;
                tempArray[index] = values[leftFirst];
                leftFirst++;
            }
            else
            {
                finalCount++;
                tempArray[index] = values[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while (leftFirst <= leftLast)
        // Copy remaining items from left half.
        {
            tempArray[index] = values[leftFirst];
            leftFirst++;
            index++;
        }
        while (rightFirst <= rightLast)
        // Copy remaining items from right half.
        {
            tempArray[index] = values[rightFirst];
            rightFirst++;
            index++;
        }
        for (index = saveFirst; index <= rightLast; index++)
        {
            values[index] = tempArray[index];
        }
    }
    
    public long getCounter()
    {
        return finalCount;
    }
}
