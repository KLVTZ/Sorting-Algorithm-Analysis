//   _____           _    _        _ _    _____            _   
//  / ____|         | |  | |      (_) |  / ____|          | |  
// | |     ___   ___| | _| |_ __ _ _| | | (___   ___  _ __| |_ 
// | |    / _ \ / __| |/ / __/ _` | | |  \___ \ / _ \| '__| __|
// | |___| (_) | (__|   <| || (_| | | |  ____) | (_) | |  | |_ 
//  \_____\___/ \___|_|\_\\__\__,_|_|_| |_____/ \___/|_|   \__|
                                                             
                                                             
package sorts;

public class cocktailSort 
{
    static long finalCount = 0;
    
    public cocktailSort(int[] values)
    {
        boolean swapped;
        do
        {
            swapped = false;
            for(int index = 0; index <= values.length - 2; index++)
            {
                if(values[index] > values[index + 1])
                {
                    // xchg
                    int temp = values[index];
                    values[index] = values[index + 1];
                    values[index + 1] = temp;
                    swapped = true;
                    finalCount++;
                }
            }
            if(!swapped)
            {
                // no xchg = complete sort
                break;
            }
            swapped = false;
            for(int counter = values.length - 2; counter >= 0; counter--)
            {
                if(values[counter] > values[counter + 1])
                {
                    // xchg
                    int temp = values[counter];
                    values[counter] = values[counter + 1];
                    values[counter + 1] = temp;
                    swapped = true;
                    finalCount++;
                }
            }
            // no xchg = complete sort
        } while(swapped);
    }
    
    public long getCounter()
    {
        return finalCount;
    }
}
