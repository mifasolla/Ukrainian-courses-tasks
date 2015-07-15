package com.mifasolla;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Vika on 13.07.2015.
 */
public class HeapSolution {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> A =
                readArrayFromFile("D:\\courses\\Algorithm Analysis, Ukraine\\task 5\\control_input.txt");

        Heap hLow = new Heap(new ArrayList<Integer>(), true);
        Heap hHigh = new Heap(new ArrayList<Integer>(),false);

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) < hLow.heapTop()) {
                hLow.heapInsert(A.get(i));
            } else {
                hHigh.heapInsert(A.get(i));
            }

            if(hLow.getHeapSize() >= hHigh.getHeapSize() + 2) {
                int extract = hLow.heapExtractTopElement();
                hHigh.heapInsert(extract);
            } else if(hHigh.getHeapSize() >= hLow.getHeapSize() + 2) {
                int extract = hHigh.heapExtractTopElement();
                hLow.heapInsert(extract);
            }

            //if((i+1)%2 == 0)
            if(i + 1 == 9876){
                System.out.println("Iteration: " + (i + 1));
                System.out.println("The first median: " + hLow.heapTop());
                System.out.println("The second median: " + hHigh.heapTop());
                System.out.print("H_Low: ");
                hLow.showArray();
                System.out.print("H_High: ");
                hHigh.showArray();
                System.out.println("***********************************");
            } if(i + 1 == 2015) {
                System.out.println("Iteration: " + (i + 1));
                if(hLow.getHeapSize() > hHigh.getHeapSize()) {
                    System.out.println("The median: " + hLow.heapTop());
                    System.out.print("H_Low: ");
                    hLow.showArray();
                    System.out.print("H_High: ");
                    hHigh.showArray();
                    System.out.println("***********************************");
                } else {
                    System.out.println("The median: " + hHigh.heapTop());
                    System.out.print("H_Low: ");
                    hLow.showArray();
                    System.out.print("H_High: ");
                    hHigh.showArray();
                    System.out.println("***********************************");
                }
            }
        }

    }





    public static ArrayList<Integer> readArrayFromFile(String fileName) throws FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> resultArray = new ArrayList<Integer>();
        try {
            int length = Integer.parseInt(in.readLine());
            String line = null;
            int i = 0;

            while((line = in.readLine()) != null){
                resultArray.add(Integer.parseInt(line));
                i++;
                if(i == length) break;
            }
        } catch (IOException e){

        }
        return resultArray;
    }
}
