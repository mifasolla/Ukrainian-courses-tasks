package com.mifasolla;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Vika on 28.06.2015.
 */
public class QuickSortSolution {
    public static int count = 0;
    public static void main(String[] args) throws FileNotFoundException {

        int[] A = new int []{100,
                98,
                94,
                52,
                90,
                36,
                81,
                16,
                24,
                27,
                51,
                79,
                1,
                29,
                44,
                88,
                49,
                80,
                91,
                19,
                46,
                53,
                97,
                78,
                18,
                70,
                40,
                61,
                43,
                59,
                13,
                4,
                25,
                54,
                21,
                41,
                39,
                38,
                65,
                60,
                17,
                89,
                8,
                72,
                85,
                9,
                74,
                73,
                95,
                96,
                5,
                7,
                20,
                22,
                45,
                10,
                86,
                15,
                23,
                14,
                31,
                64,
                92,
                87,
                75,
                30,
                83,
                6,
                56,
                50,
                33,
                66,
                28,
                3,
                32,
                67,
                69,
                71,
                68,
                35,
                12,
                84,
                48,
                63,
                76,
                58,
                62,
                26,
                42,
                37,
                99,
                77,
                93,
                11,
                2,
                82,
                57,
                55,
                47
        };

        int[] a = readArrayFromFile("D:\\courses\\Algorithm Analysis, Ukraine\\task 3\\input_10000.txt");

      /*  for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }
        System.out.println();*/
        System.out.println("Sorted Array:");



        quickSort(a, 0, a.length - 1);

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(count);

    }

    public static void quickSort(int [] A, int p, int r){

        if(p < r) {
            int q = partition( A,  p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }

    }

    public static int partition(int [] A, int p, int r){

        int median = A[(r+p)/2];
        int x;
        if((A[r] >= median && median >= A[p])||(A[p] >= median && median >= A[r])) {
            A[(r+p)/2] = A[r];
            A[r] = median;
        } else if ((median>=A[p]&&A[p]>=A[r])||(A[r]>=A[p]&&A[p]>=median)){
            int swap1 = A[r];
            A[r] = A[p];
            A[p] = swap1;
        }
        x = A[r];
       /* System.out.println("Partition: ");
        System.out.println("x = " + x);
        System.out.println("p = " + p);
        System.out.println("r = " + r);
        System.out.println("i = " + (p - 1));*/
        int i = p - 1;
        for (int j = p; j < r ; j++){
            count++;
            if (A[j] <= x) {

//                System.out.println("Swapped if");
                i++;
                int swap = A[i];
                A[i] = A[j];
                A[j] = swap;
               /* for(int k = 0; k < A.length; k++){
                    System.out.print(A[k] + " ");
                }
                System.out.println();*/
            }
        }

            A[r] = A[i + 1];
            A[i + 1] = x;
//        System.out.println("return " + (i));
        //if(i == -1)
         return i + 1;
       // return i;
    }

    public static int[] readArrayFromFile(String fileName) throws FileNotFoundException{
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        int [] resultArray = null;
        try {
            int length = Integer.parseInt(in.readLine());
            resultArray = new int [length];
            String line = null;
            int i = 0;

            while((line = in.readLine()) != null){
                resultArray[i] = Integer.parseInt(line);
                i++;
                if(i == length) break;
            }
        } catch (IOException e){

        }
        return resultArray;
    }
}
