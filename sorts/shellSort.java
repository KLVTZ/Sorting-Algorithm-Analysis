//   _____ _          _ _    _____            _   
//  / ____| |        | | |  / ____|          | |  
// | (___ | |__   ___| | | | (___   ___  _ __| |_ 
//  \___ \| '_ \ / _ \ | |  \___ \ / _ \| '__| __|
//  ____) | | | |  __/ | |  ____) | (_) | |  | |_ 
// |_____/|_| |_|\___|_|_| |_____/ \___/|_|   \__|                                                
package sorts;

public class shellSort 
{
    static final int SIZE = 100000;
    static long finalCount = 0;
    
    public shellSort(int[] values)
    {
        int hand = 1;
        while(hand < SIZE / 3)
        {
            hand = 3 * hand + 1;
        }
        while(hand >= 1)
        {
            for(int index = hand; index < SIZE; index++)
            {
                for(int counter = index; counter >= hand &&
                        less(values[counter], values[counter - hand]); counter -= hand)
                {
                    exch(values, counter, counter - hand);
                }
            }
            hand = hand / 3;
        }
    }
    
    private static boolean less(Comparable valOne, Comparable valTwo)
    {
        return valOne.compareTo(valTwo) < 0;
    }
    
    private static void exch(int[] values, int index, int counter)
    {
        int swap = values[index];
        values[index] = values[counter];
        values[counter] = swap;
        finalCount++;
    }
    
    public long getCounter()
    {
        return finalCount;
    }
}
