///////////////////////////////////////////////////////////////////////////
//  ______  ______ ______  ______     __     __  ______  ______ ______  __  __    
// /\  ___\/\__  _/\  __ \/\  == \   /\ \  _ \ \/\  __ \/\__  _/\  ___\/\ \_\ \   
// \ \___  \/_/\ \\ \ \/\ \ \  _-/   \ \ \/ ".\ \ \  __ \/_/\ \\ \ \___\ \  __ \  
//  \/\_____\ \ \_\\ \_____\ \_\      \ \__/".~\_\ \_\ \_\ \ \_\\ \_____\ \_\ \_\ 
//   \/_____/  \/_/ \/_____/\/_/       \/_/   \/_/\/_/\/_/  \/_/ \/_____/\/_/\/_/ 
                                                                              
package algoanalysis;

public class Stopwatch 
{
    private final long start;
    public Stopwatch()
    {
        start = System.currentTimeMillis();
    }
    
    public double elapsedTime()
    {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
