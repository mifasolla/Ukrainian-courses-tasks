package com.mifasolla;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Created by Vika on 27.06.2015.
 */
public class SortSolution {
    public static void main(String[] args) {

        int [] arrayForSort = new int[]{20, 10, 12,1,1, 19, -1, 0};
        int [] largeArray = new int[100000];
        Random rand = new Random();
        for(int i = 0; i < 100000; i++){
            largeArray[i] = rand.nextInt(100);
        }

        int [] sortedLargeArray = new int[100000];
        sortedLargeArray = mergeSort(largeArray);
    try {
        write("D:\\courses\\Algorithm Analysis, Ukraine\\task 2\\in.txt", largeArray);
         write("D:\\courses\\Algorithm Analysis, Ukraine\\task 2\\out.txt", sortedLargeArray);
    } catch(FileNotFoundException e){

    } catch (IOException e){

    }

       /* for(int i = 0; i < arrayForSort.length; i++){
            System.out.println(arrayForSort[i]);
        }

        int [] sortedArray = new int[arrayForSort.length];
        sortedArray = mergeSort(arrayForSort);

        System.out.println("\nSorted array:\n");

       for(int i = 0; i < sortedArray.length; i++){
           System.out.println(sortedArray[i]);
       }
       */



    }

    public static int [] mergeSort(int [] A) {

        if (A.length == 1) {
            return A;
        } else {
            int [] arrayForSorting = new int [A.length];
            int q = A.length/2;

            int [] leftArray = new int [q];
            int [] rightArray = new int [A.length - q];
            for(int i = 0; i < q; i++){
                leftArray[i] = A[i];
            }
            for(int i = 0; i < A.length - q; i++){
                rightArray[i] = A[i+q];
            }

            arrayForSorting = merge(mergeSort(leftArray), mergeSort(rightArray));
            return arrayForSorting;
        }
    }

    public static int [] merge(int [] leftArray, int [] rightArray){
        int i = 0;
        int j = 0;

        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int k = 0;

        int [] sortedArray = new int [leftSize + rightSize];

        while (k < sortedArray.length){
            if (leftArray[i] <= rightArray[j]) {
                sortedArray[k] = leftArray[i];
                i++;
                if (i >= leftSize) {
                    for(int nk = k + 1; nk < sortedArray.length; nk++){
                        sortedArray[nk] = rightArray[j];
                        j++;
                    }
                    break;
                }
            } else {
                sortedArray[k] = rightArray[j];
                j++;
                if (j >= rightSize) {
                    for(int nk = k + 1; nk < sortedArray.length; nk++){
                        sortedArray[nk] = leftArray[i];
                        i++;
                    }
                    break;
                }
            }
            k++;
        }

        return sortedArray;
    }

    public static void write (String filename, int[]x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < x.length; i++) {
            // Maybe:
            //outputWriter.write(x[i]+"");
            // Or:
            outputWriter.write(Integer.toString(x[i]));
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }
}
