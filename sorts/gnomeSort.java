//   _____                               _____            _   
//  / ____|                             / ____|          | |  
// | |  __ _ __   ___  _ __ ___   ___  | (___   ___  _ __| |_ 
// | | |_ | '_ \ / _ \| '_ ` _ \ / _ \  \___ \ / _ \| '__| __|
// | |__| | | | | (_) | | | | | |  __/  ____) | (_) | |  | |_ 
//  \_____|_| |_|\___/|_| |_| |_|\___| |_____/ \___/|_|   \__|
                                                            
                                                           
package sorts;

public class gnomeSort 
{
    static long finalCount = 0;
    
    public gnomeSort(int[] values)
    {
        int index = 1;
        int hand  = 2;
        int temp;
        
        while(index < values.length)
        {
            if(values[index - 1] <= values[index])
            {
                index = hand;
                hand++;
            }
            else
            {
                temp = values[index - 1];
                values[index - 1] = values[index];
                values[index--] = temp;
                index = (index == 0) ? hand++ : index;
                finalCount++;
            }
        }
    }
    
    public long getCounter()
    {
        return finalCount;
    }
}
