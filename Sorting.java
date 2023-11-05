import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorting {
    
    public static Long calculateUsageMemory(List<Integer> data, Integer option){
        // source : https://stackoverflow.com/questions/37916136/how-to-calculate-memory-usage-of-a-java-program

        long beforeUsedMem, afterUsedMem, actualMemUsed;
        beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if(option == 1){
            TwoPivotBlock.dualPivotQuickSort(data, 0, data.size() - 1);
        } else{
            MergeSort.sort(data, 0, data.size()-1);
        }
        afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        actualMemUsed = afterUsedMem - beforeUsedMem;

        return actualMemUsed;
    }

    public static void calculateTime( List<Integer> data, Integer option){
        long start = System.nanoTime();
        System.out.println("Memory Usage : "+ calculateUsageMemory(data, option));
        long end = System.nanoTime();
        long elapsedTime = end - start; 
        System.out.println("Time         : " + elapsedTime +" nanosecond");
    }

    public static void compareAlgo(List<Integer> data){
        System.out.println("" );
        System.out.println("-----Two-Pivot-Block-Quicksort-----");
        calculateTime(data,1);
        System.out.println("" );

        System.out.println("-----------Merge Sort--------------" );
        calculateTime(data,2);
         System.out.println("" );
    }

    public static List<Integer> readFile(String fileName){
        List<Integer> result= new ArrayList<Integer>();

        try {
            File myObj = new File(fileName);

            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result.add(Integer.valueOf(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return result;
    }

      public static void main(String[] args) {

        Integer option = 2; // 1: random;  2: Sorted  ; 3: Reverse
        
        String type = option == 1 ? "Random" : option == 2 ? "Sorted" : "Reverse";

        List<Integer> small = readFile("Small"+type+".txt");
        List<Integer> medium= readFile("Medium"+type+".txt");
        List<Integer> big = readFile("Big"+type+".txt");


        System.out.println("================================================");
        System.out.println("           MELAKUKAN PROSES DATA "+ type);
        System.out.println("================================================");
        
        // Sorting Sorted Array 2^9
        System.out.println("================================================");
        System.out.println("                     SMALL                      ");
        compareAlgo(small);
        System.out.println("================================================");

        // Sorting Sorted Array 2^13
        System.out.println("                     MEDIUM                      ");
        compareAlgo(medium);         
        System.out.println("================================================");

        // Sorting Sorted Array 2^16
        System.out.println("                      BIG                      ");
        // compareAlgo(big);  
        System.out.println("================================================");

    }
}
