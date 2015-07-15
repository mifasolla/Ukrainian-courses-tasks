package com.mifasolla;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Vika on 15.07.2015.
 */
public class CourseSolution {
    private HashTable ht;
    private long [] dataArray;

    public CourseSolution(long [] dataArray) {
        this.dataArray = dataArray;
        ht = new HashTable(this.dataArray);
        ht.createHashList();
    }

    public int countOfSums(){
        int count = 0;

        for(int s = -1000; s < 1001; s++){
            int i = 0;
            while(i < dataArray.length) {
                long y = s - dataArray[i];
                if(y != dataArray[i] && ht.hashListConsist(y)) {
                    count++;
                //    System.out.println("+1");
                    break;
                }
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {

        long [] dataArray = readArrayFromFile("D:\\courses\\Algorithm Analysis, Ukraine\\task 6\\test_06_1.txt");
        CourseSolution cs = new CourseSolution(dataArray);

        int count = cs.countOfSums();
        System.out.println(count);
    }

    public static long[] readArrayFromFile(String fileName) throws FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        long [] resultArray = null;
        try {
            int length = Integer.parseInt(in.readLine());
            String line = null;
           // int length = 1000000; // for "input_06.txt"
            resultArray = new long[length];
            int i = 0;

            while((line = in.readLine()) != null){
                resultArray[i] = (Long.parseLong(line));
                i++;
                if(i == length) break;
            }
        } catch (IOException e){

        }
        return resultArray;
    }
}
