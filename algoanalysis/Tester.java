// @2013 // KLVTZ
////////////////////////////////////////////////////////////////////////////////
/*
               ____  __________________   __   ____  ___   ____________
               / / / / / ___/_  __/  _/ | / /  / __ \/   | / ____/ ____/
          __  / / / / /\__ \ / /  / //  |/ /  / /_/ / /| |/ / __/ __/   
         / /_/ / /_/ /___/ // / _/ // /|  /  / ____/ ___ / /_/ / /___   
         \____/\____//____//_/ /___/_/ |_/  /_/   /_/  |_\____/_____/                                                              

*/                                                                      
////////////////////////////////////////////////////////////////////////////////


package algoanalysis;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sorts.*;


public class Tester 
{
    
    // assume psuedoRandAsc || psuedoRandDesc || rand => size_of 100,000 
    static final int SIZE = 100000;
    static final int NMBr = 7;
    static final int NMBc = 2;
    
    static String[][] sorts = new String[NMBr][NMBc];
    static String[] swapNames = new String[NMBr];
    static long[] swapValues = new long[NMBr];
    static int[] values = new int[SIZE];
    static Scanner scan;
    
    // init values that will be inserted into the array to be then sorted.
    static void selection(int selection)
    {
        switch(selection)
        {
            case 1:
                System.out.println("Psuedo Random Ascending Selected. ");
                System.out.println("------------------------------------------------------\n");
                break;
            case 2:
                System.out.println("Psuedo Random Descending Selected. ");
                System.out.println("------------------------------------------------------\n");
                break;
            case 3:
                System.out.println("Random Selected. ");
                System.out.println("------------------------------------------------------\n");
                break;
        }
    }
    
    static void initValues(int selection)
    {
        int index = 0;
        // switch-case method for choosing which file to input in array
        // try-catch included for extra security of file existance.

        switch(selection)
        {
            case 1:
                // selection = psuedoRandAsc.txt
                // insert psuedoRandAsc.txt => values
                try {
                    scan = new Scanner(new File("pseudoRandAsc.txt"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(scan.hasNextInt())
                {
                    values[index++] = scan.nextInt();
                }
                break;
            case 2:
                // selection = psuedoRandDesc.txt
                // insert psuedoRandDesc.txt => values
                try {
                    scan = new Scanner(new File("pseudoRandDesc.txt"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(scan.hasNextInt())
                {
                    values[index++] = scan.nextInt();
                }
                break;
            case 3:
                // selection = rand.txt
                // insert rand.txt => values
                try {
                    scan = new Scanner(new File("rand.txt"));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(scan.hasNext())
                {
                    values[index++] = scan.nextInt();
                }
                break;
            default:
                // ends program because of invalid selection
                System.out.println("Program will now terminate.");
                System.exit(0);
        }
    }
    
    // prints current values of array
    static public void printValues()
    {
        int value, counter = 1;
        DecimalFormat fmt = new DecimalFormat("#");
        System.out.println("The values array is = ");
        
        for(int index = 0; index < SIZE; index++)
        {
            value = values[index];
            if (((index + 1) % 100000) == 0)
            {
                System.out.println(fmt.format(value));
            }
            else 
            {
                System.out.print(fmt.format(value) + " ");
            }
            // additional format add for tabular style
            if(counter == 50)
            {
                counter = 1;
                System.out.println(); 
            }
            counter++;
        }
        
    }
    
    // Returns true if the array values are sorted and false otherwise.
    static public boolean isSorted()
    {
        boolean sorted = true;
        for(int index = 0; index < (SIZE - 1); index++)
        {
            if(values[index] > values[index + 1])
            {
                sorted = false;
            }
        }
        return sorted;
    }
    
    
////////////////////////////////////////////////////////////////////////////////             _      
//  _ __  __ _(_)_ _  
// | '  \/ _` | | ' \ 
// |_|_|_\__,_|_|_||_|    
//
////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) 
    { 
       int selection;
       long b_swaps;
       double time;
       long totalSwaps = 0;
       double totalTime = 0;
       int outerCounter = 0;
       int innerCounter;
       Stopwatch stopwatch;
       DecimalFormat df = new DecimalFormat("#,###,###,###");
       DecimalFormat sf = new DecimalFormat("#.##");
        
       System.out.println("The following tester will demonstrate seven sorting algorithms.");
       System.out.println("Please select which data file you would like to sort: ");
       
       // asks user for which data type to use in order to sort.
       while(outerCounter != 3) 
       {
        int index = 0;
        System.out.println("\n(1) = Psuedo Random Ascending Data");
        System.out.println("(2) = Psuedo Random Descending Data");
        System.out.println("(3) = Random Data");
        System.out.println("(-1) = End Program");
        System.out.print("\nSelection => ");

        scan = new Scanner(System.in);
        selection = scan.nextInt();


     ///////////////////////////////////////////////////////////////////////////
     //    ___          _        ___         _      
     //   | _ )___ __ _(_)_ _   / __|___ _ _| |_ ___
     //   | _ / -_/ _` | | ' \  \__ / _ | '_|  _(_-<
     //   |___\___\__, |_|_||_| |___\___|_|  \__/__/
     //           |___/                              
     //   
     //
     //  =Selection(1) = Psuedo Random Ascending Data = Started
     //  =Selection(2) = Psuedo Random Descending Data = Started
     //  =Selection(3) = Random Data = Started
     ///////////////////////////////////////////////////////////////////////////

 
        
        System.out.println();
        /////////////////////////////////////////////////////////
        //  =Merge Sort
        /////////////////////////////////////////////////////////

        // insert selected text file
        selection(selection);
        initValues(selection);
        System.out.println("Mege Sort: ");
        
        //printValues();
        System.out.println("Sorted = " + isSorted());
        System.out.println("(processing)");
        
        // start mergeSort
        // inner counter handles iteration of three for average time && sort
        innerCounter = 0;
        
        // begin average
        while(innerCounter < 3)
        {
            initValues(selection);
            // get current time and swap three times and add to total
            stopwatch = new Stopwatch();
            mergeSort mSort = new mergeSort(0, SIZE-1, values);
            time = stopwatch.elapsedTime();
            totalTime += time;
            b_swaps = mSort.getCounter();
            totalSwaps += b_swaps;
            innerCounter++;
        }
        // final average
        totalTime = totalTime / 3;
        totalSwaps = totalSwaps / 3;
        
        // decimal fix - #.##
        totalTime = Double.parseDouble(sf.format(totalTime));
        
        //printValues();
        System.out.println("Sorted = " + isSorted() + "\n");
        System.out.println("Merge Sort takes on average " 
                + totalTime + "ms to complete the sort.");
        System.out.println("Total number of average swaps: " 
                + df.format(totalSwaps));
        
        // insert name && time
        sorts[index][0] = "Merge Sort";
        sorts[index][1] = Double.toString(totalTime);

        
        // insert name && swaps
        swapNames[index] = "Merge Sort";
        swapValues[index] =  totalSwaps;
        ++index;
        
        
        
        
        System.out.println();
        /////////////////////////////////////////////////////////
        //  =Quick Sort
        /////////////////////////////////////////////////////////

        // insert selected text file
        System.out.println("Quick Sort: ");
        initValues(selection);
        
        //printValues();
        System.out.println("Sorted = " + isSorted());
        System.out.println("(processing)");
        
        // start heapSort
        // inner counter handles iteration of three average time && sort
        innerCounter = 0;
        
        // begin average
        while(innerCounter < 3)
        {
            initValues(selection);
            stopwatch = new Stopwatch();
            quickSort qSort = new quickSort(0, SIZE - 1, values);
            time = stopwatch.elapsedTime();
            totalTime += time;
            b_swaps = qSort.getCounter();
            totalSwaps += b_swaps;
            innerCounter++;
        }
        // final average
        totalTime = totalTime / 3;
        totalSwaps = totalSwaps / 3;
        
        // decimal fix - #.##
        totalTime = Double.parseDouble(sf.format(totalTime));
        
        //printValues();
        System.out.println("Sorted = " + isSorted() + "\n");
        System.out.println("Quick Sort takes on average " 
                + totalTime + "ms to complete the sort.");
        System.out.println("Total number of average swaps: " 
                + df.format(totalSwaps));
        
        // insert name && time
        sorts[index][0] = "Quick Sort";
        sorts[index][1] = Double.toString(totalTime);

        
        // insert name && swaps
        // insert name && swaps
        swapNames[index] = "Quick Sort";
        swapValues[index] =  totalSwaps;
        ++index;
      

        
        System.out.println();
        /////////////////////////////////////////////////////////
        //  =Heap Sort
        /////////////////////////////////////////////////////////

        // insert selected text file
        System.out.println("Heap Sort: ");
        initValues(selection);
        
        //printValues();
        System.out.println("Sorted = " + isSorted());
        System.out.println("(processing)");
        
        // start heapSort
        // inner counter handles iteration of three average time && sort
        innerCounter = 0;
        
        // begin average
        while(innerCounter < 3)
        {
            initValues(selection);
            stopwatch = new Stopwatch();
            heapSort hSort = new heapSort(values);
            time = stopwatch.elapsedTime();
            totalTime += time;
            b_swaps = hSort.getCounter();
            totalSwaps += b_swaps;
            innerCounter++;
        }
        // final average
        totalTime = totalTime / 3;
        totalSwaps = totalSwaps / 3;
        
        // decimal fix - #.##
        totalTime = Double.parseDouble(sf.format(totalTime));
        
        //printValues();
        System.out.println("Sorted = " + isSorted() + "\n");
        System.out.println("Heap Sort takes on average " 
                + totalTime + "ms to complete the sort.");
        System.out.println("Total number of average swaps: " 
                + df.format(totalSwaps));
        
        // insert name && time
        sorts[index][0] = "Heap Sort";
        sorts[index][1] = Double.toString(totalTime);

        
        // insert name && swaps
        swapNames[index] = "Heap Sort";
        swapValues[index] =  totalSwaps;
        ++index;
        
        
        
        
        System.out.println();
        /////////////////////////////////////////////////////////
        //  =Shell Sort
        /////////////////////////////////////////////////////////

        // insert selected text file
        System.out.println("Shell Sort: ");
        initValues(selection);
        
        //printValues();
        System.out.println("Sorted = " + isSorted());  
        System.out.println("(processing)");
        
        // start shellSort
        // inner counter handles iteration of three average time && sort
        innerCounter = 0;
        
        // begin average
        while(innerCounter < 3)
        {
            initValues(selection);
            stopwatch = new Stopwatch();
            shellSort sSort = new shellSort(values);
            time = stopwatch.elapsedTime();
            totalTime += time;
            b_swaps = sSort.getCounter();
            totalSwaps += b_swaps;
            innerCounter++;
        }
        // final average
        totalTime = totalTime / 3;
        totalSwaps = totalSwaps / 3;
        
        // decimal fix - #.##
        totalTime = Double.parseDouble(sf.format(totalTime));
        
        //printValues();
        System.out.println("Sorted = " + isSorted() + "\n");
        System.out.println("Shell Sort takes on average " 
                + totalTime + "ms to complete the sort.");
        System.out.println("Total number of average swaps: " 
                + df.format(totalSwaps));
        
        // insert name && time
        sorts[index][0] = "Shell Sort";
        sorts[index][1] = Double.toString(totalTime);

        
        // insert name && swaps
        swapNames[index] = "Shell Sort";
        swapValues[index] =  totalSwaps;
        ++index;

        
        
        
        System.out.println();
        /////////////////////////////////////////////////////////
        //  =Cocktail Sort
        /////////////////////////////////////////////////////////

        // insert selected text file
        System.out.println("Cocktail Sort: ");
        initValues(selection);
        
        //printValues();
        System.out.println("Sorted = " + isSorted());
        System.out.println("(processing)");
        
        // start shellSort
        // inner counter handles iteration of three average time && sort
        innerCounter = 0;
        
        // begin average
        while(innerCounter < 3)
        {
            initValues(selection);
            stopwatch = new Stopwatch();
            cocktailSort cSort = new cocktailSort(values);
            time = stopwatch.elapsedTime();
            totalTime += time;
            b_swaps = cSort.getCounter();
            totalSwaps += b_swaps;
            innerCounter++;
        }

        // final average
        totalTime = totalTime / 3;
        totalSwaps = totalSwaps / 3;
        
        // decimal fix - #.##
        totalTime = Double.parseDouble(sf.format(totalTime));
        
        //printValues();
        System.out.println("Sorted = " + isSorted());
        System.out.println("Cocktail Sort takes on average " 
                + totalTime + "ms to complete the sort.");
        System.out.println("Total number of average swaps: " 
                + df.format(totalSwaps));
        
        // insert name && time
        sorts[index][0] = "Cocktail Sort";
        sorts[index][1] = Double.toString(totalTime);

        
        // insert name && swaps
        swapNames[index] = "Cocktail Sort";
        swapValues[index] =  totalSwaps;
        ++index;
        
        
        
        System.out.println();
        /////////////////////////////////////////////////////////
        //  =Gnome Sort
        /////////////////////////////////////////////////////////

        // insert selected text file
        System.out.println("Gnome Sort: ");
        initValues(selection);
        
        //printValues();
        System.out.println("Sorted = " + isSorted());
        System.out.println("(processing)");
        
        // start shellSort
        // inner counter handles iteration of three average time && sort
        innerCounter = 0;
        
        // begin average
        while(innerCounter < 3)
        {
            initValues(selection);
            stopwatch = new Stopwatch();
            gnomeSort gSort = new gnomeSort(values);
            time = stopwatch.elapsedTime();
            totalTime += time;
            b_swaps = gSort.getCounter();
            totalSwaps += b_swaps;
            innerCounter++;
        }
        // final average
        totalTime = totalTime / 3;
        totalSwaps = totalSwaps / 3;
        
        // decimal fix - #.##
        totalTime = Double.parseDouble(sf.format(totalTime));
        
        //printValues();
        System.out.println("Sorted = " + isSorted() + "\n");
        System.out.println("Gnome Sort takes on average " 
                + totalTime + "ms to complete the sort.");
        System.out.println("Total number of average swaps: " 
                + df.format(totalSwaps));
        
        // insert name && time
        sorts[index][0] = "Gnome Sort";
        sorts[index][1] = Double.toString(totalTime);

        
        // insert name && swaps
         swapNames[index] = "Gnome Sort";
        swapValues[index] =  totalSwaps;
        ++index;
        
        
        
        
        System.out.println();
        /////////////////////////////////////////////////////////
        //  =insertion Sort
        /////////////////////////////////////////////////////////

        // insert selected text file
        System.out.println("Insertion Sort: ");
        initValues(selection);
        
        //printValues();
        System.out.println("Sorted = " + isSorted());
        System.out.println("(processing)");
        
        // start shellSort
        // inner counter handles iteration of three average time && sort
        innerCounter = 0;
        
        // begin average
        while(innerCounter < 3)
        {
            initValues(selection);
            stopwatch = new Stopwatch();
            insertionSort iSort = new insertionSort(values);
            time = stopwatch.elapsedTime();
            totalTime += time;
            b_swaps = iSort.getCounter();
            totalSwaps += b_swaps;
            innerCounter++;
        }
        // final average
        totalTime = totalTime / 3;
        totalSwaps = totalSwaps / 3;
        
        // decimal fix - #.##
        totalTime = Double.parseDouble(sf.format(totalTime));
        
        //printValues();
        System.out.println("Sorted = " + isSorted() + "\n");
        System.out.println("Insertion Sort takes on average " 
                + totalTime + "ms to complete the sort.");
        System.out.println("Total number of average swaps: " 
                + df.format(totalSwaps));
        
        // insert name && time
        sorts[index][0] = "Insertion Sort";
        sorts[index][1] = Double.toString(totalTime);

        
        // insert name && swaps
        swapNames[index] = "Insertion Sort";
        swapValues[index] =  totalSwaps;
        ++index;
     
        
        
     ///////////////////////////////////////////////////////////////////////////
     //   ___         _   ___         _      
     //  | __|_ _  __| | / __|___ _ _| |_ ___
     //  | _|| ' \/ _` | \__ / _ | '_|  _(_-<
     //  |___|_||_\__,_| |___\___|_|  \__/__/
     //                                
     //   
     //
     //  =Selection(1) = Psuedo Random Ascending Data = Complete
     //  =Selection(2) = Psuedo Random Descending Data = Complete
     //  =Selection(3) = Random Data = Complete
     ///////////////////////////////////////////////////////////////////////////        
        
        
        // Sort sorts array by miliseconds or column 2
        System.out.println("\n");
        Arrays.sort(sorts, new ColumnComparator(1));
        
        
        // Print sorted sorting time array
        int hand;
        int counter;
        
        System.out.println("Sorting times: ");
        for(hand = 0; hand < sorts.length; hand++)
        {
            String[] row = sorts[hand];
            for(counter = 0; counter < row.length; counter++)
            {
                System.out.print(row[counter] + "\t|");
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        
        System.out.println("\n");
        InsertSort insertSort = new InsertSort(swapValues, swapNames);
        
        // Print sorted swaps array
        System.out.println("\nSwapping totals: ");
        for(hand = 0; hand < swapValues.length; hand++)
        {
            System.out.print(swapNames[hand] + "\t|");
            System.out.print("\t");
            System.out.print(df.format(swapValues[hand]) + "\t|");
            System.out.print("\t");
            System.out.print("\n");
        }
        outerCounter++;
     } 
   }
}

// overwrite Object class method; sorts final string averages
class ColumnComparator implements Comparator {
  int columnToSort;
	ColumnComparator(int columnToSort) {
		this.columnToSort = columnToSort;
	}
	//overriding compare method
	public int compare(Object o1, Object o2) {
		String[] row1 = (String[]) o1;
		String[] row2 = (String[]) o2;
		//compare the columns to sort
		return Double.valueOf(row1[columnToSort])
                        .compareTo(Double.valueOf(row2[columnToSort]));
	}
}

// additional sort for long swap values && overflow decimal fix
class InsertSort 
{
    static final int SIZE = 7;
    static long[] swapValues;
    static String[] swapNames;
    
    public InsertSort(long[]swapValues, String[]swapNames)
    {
        InsertSort.swapValues = swapValues;
        InsertSort.swapNames = swapNames;
        
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
            if(swapValues[current] < swapValues[current - 1])
            {
                swap(current, current - 1);
                swapName(current, current - 1);
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
        long temp = swapValues[index1];
        swapValues[index1] = swapValues[index2];
        swapValues[index2] = temp;
        
    } 
    
    static public void swapName(int index1, int index2)
    // Precondition: index1 and index2 are >= 0 and < SIZE.
    //
    // Swaps the integers at locations index1 and index2 of the values array. 
    {
        String temp = swapNames[index1];
        swapNames[index1] = swapNames[index2];
        swapNames[index2] = temp;
        
    } 
}
