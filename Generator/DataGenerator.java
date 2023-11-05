package Generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DataGenerator {

    public static void write(ArrayList<Integer> data, String fileName) throws IOException{
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < data.size(); i++) {
 
            fileOut.write(data.get(i)+"");
            fileOut.newLine();
        }

        fileOut.flush();
        fileOut.close();
    }
    public static void main(String[] args) throws IOException{

        ArrayList<Integer> data = new ArrayList<Integer>();
        double mult = 16.0; //  Ganti 9.0: Small, 13.0: Medium, 16.0:Big
        String name = "Big";
        
        Random rand = new Random();
        Double maxNumber = Math.pow(2.0, mult); 
            
        for(int i = 0; i < maxNumber; i++){
                data.add(rand.nextInt(100000));
        }

        write(data, name+"Random.txt");

        Collections.sort(data);
        ArrayList<Integer> sorted = new ArrayList<Integer>(data);
        write(sorted, name+"Sorted.txt");

        Collections.reverse(data);
        ArrayList<Integer> reversSorted = new ArrayList<Integer>(data);
        write(reversSorted, name+"Reverse.txt");
    }
}
