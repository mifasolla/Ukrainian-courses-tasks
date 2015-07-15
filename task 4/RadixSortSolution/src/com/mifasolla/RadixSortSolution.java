package com.mifasolla;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Vika on 29.06.2015.
 */
public class RadixSortSolution {
    public static void main(String[] args) throws FileNotFoundException {
      /*  int [][] C = new int [2][26];
        char alpha = 'a';

        for(int i = 0; i < C[0].length; i++){
                C[0][i] = alpha;
                alpha++;
                System.out.println(alpha);
                System.out.println(C[0][i]);
            }


        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 26; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(C[0][25]==Integer.valueOf('z'));*/
        char[] A = new char[]{'b', 'c', 'a', 'f'};

        //  char[] B = countingSort(A);

        /*for(int i = 0; i < B.length; i++){
            System.out.print(B[i] + " ");
        }*/


        String[] arr = readArrayFromFile("D:\\courses\\Algorithm Analysis, Ukraine\\task 4\\baseForParole.txt");

       /* for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();*/
        maxCountLetters(arr, 3);

        radixSort(arr, 3);

        System.out.println(arr[0]);
        System.out.println(arr[arr.length - 1]);



       /* for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }*/

    }

    public static void radixSort(String[] A, int d) {
        for (int i = d - 1; i >= 0; i--) {
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int j = 0; j < A.length - 1; j++) {
                    if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                        swapped = true;
                        String swap = A[j + 1];
                        A[j + 1] = A[j];
                        A[j] = swap;
                    }
                }
            }


        }
    }

  /*  public static char[] countingSort(char[] A) {
        int k = "abcdefghijklmnopqrstuvwxyz".length();
        char alpha = 'a';
        char[] B = new char[A.length];
        int[][] C = new int[2][k];
        int index = 0;

        for (int i = 0; i < C[0].length; i++) {
            C[0][i] = alpha;
            alpha++;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                if (C[0][j] == Integer.valueOf(A[i])) C[1][j]++;
            }
        }

        for (int j = 1; j < C[0].length; j++) {
            C[1][j] += C[1][j - 1];
        }

        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = 0; j < C[0].length; j++) {
                if (C[0][j] == Integer.valueOf(A[i])) {
                    index = C[1][j] - 1;
                    C[1][j]--;
                }

                B[index] = A[i];
            }
        }
        return B;
    }*/


    public static String[] readArrayFromFile(String fileName) throws FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String[] resultArray = null;
        try {
            int length = Integer.parseInt(in.readLine());
            resultArray = new String[length];
            String line = null;
            int i = 0;

            while ((line = in.readLine()) != null) {
                resultArray[i] = line;
                i++;
                if (i == length) break;
            }
        } catch (IOException e) {

        }
        return resultArray;
    }

    public static void maxCountLetters(String[] A, int d) {


        Map<Character, Integer> C = new HashMap<Character, Integer>();
        C.put('a', 0);
        C.put('b', 0);
        C.put('c', 0);
        C.put('d', 0);
        C.put('e', 0);
        C.put('f', 0);
        C.put('g', 0);
        C.put('h', 0);
        C.put('i', 0);
        C.put('j', 0);
        C.put('k', 0);
        C.put('l', 0);
        C.put('m', 0);
        C.put('n', 0);
        C.put('o', 0);
        C.put('p', 0);
        C.put('q', 0);
        C.put('r', 0);
        C.put('s', 0);
        C.put('t', 0);
        C.put('u', 0);
        C.put('v', 0);
        C.put('w', 0);
        C.put('x', 0);
        C.put('y', 0);
        C.put('z', 0);
        for (int t = d - 1; t >= 0; t--) {
            Iterator<Map.Entry<Character, Integer>> iterator = C.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> pair = iterator.next();
                Character key = pair.getKey();
                Integer count = pair.getValue();

                for (int i = 0; i < A.length; i++) {
                    if (A[i].charAt(t) == key) {
                        count++;
                    }
                }

                C.put(key, count);
            }

        }

        int max = 0;
        char s = 'a';
        int countingMax = 0;

        Iterator<Map.Entry<Character, Integer>> iterator1 = C.entrySet().iterator();

        while(iterator1.hasNext()){
            Map.Entry<Character, Integer> pair = iterator1.next();
            int maxCount = pair.getValue();

            if(maxCount >= max){
                max = maxCount;
            }

        }

        Iterator<Map.Entry<Character, Integer>> iterator2 = C.entrySet().iterator();

        while(iterator2.hasNext()){
            Map.Entry<Character, Integer> pair = iterator2.next();
            char key = pair.getKey();
            int value = pair.getValue();

            if(value == max){
                countingMax++;
                s = key;
                System.out.println(key);
            }

        }


    }


}
