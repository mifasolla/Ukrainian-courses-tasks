package com.mifasolla;

import java.io.*;

/**
 * Created by Vika on 28.06.2015.
 */
public class InvariantsSolution {

    public static int count = 0;

    public static void main(String[] args) throws IOException {

        int[][] matrix = readMatrixFromFile("D:\\courses\\Algorithm Analysis, Ukraine\\task 2\\test_1000_100.txt");

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
         System.out.println();
        }

        int [] arrayForInvariants = createArrayForInvariants(matrix[950], matrix[177]);

        int[] sortedArray = mergeSort(arrayForInvariants);

        System.out.println(count);
    }



    public static int[] mergeSort(int[] A) {

        if (A.length == 1) {
            return A;
        } else {
            int[] arrayForSorting = new int[A.length];
            int q = A.length / 2;

            int[] leftArray = new int[q];
            int[] rightArray = new int[A.length - q];
            for (int i = 0; i < q; i++) {
                leftArray[i] = A[i];
            }
            for (int i = 0; i < A.length - q; i++) {
                rightArray[i] = A[i + q];
            }

            arrayForSorting = merge(mergeSort(leftArray), mergeSort(rightArray));
            return arrayForSorting;
        }
    }

    public static int[] merge(int[] leftArray, int[] rightArray) {
        int i = 0;
        int j = 0;

        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int k = 0;

        int[] sortedArray = new int[leftSize + rightSize];

        while (k < sortedArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                sortedArray[k] = leftArray[i];
                i++;
                if (i >= leftSize) {
                    for (int nk = k + 1; nk < sortedArray.length; nk++) {
                        sortedArray[nk] = rightArray[j];
                        j++;
                    }
                    break;
                }
            } else {
                sortedArray[k] = rightArray[j];
                j++;
                count+=leftSize - i;
                if (j >= rightSize) {
                    for (int nk = k + 1; nk < sortedArray.length; nk++) {
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

    public static int[] createArrayForInvariants(int[] firstArray, int[] secondArray) {

        int[] arrayForInvariants = new int[firstArray.length];

        for(int i = 0; i < secondArray.length; i++) {
            secondArray[i]--;
            firstArray[i]--;
        }

        for (int i = 0; i < arrayForInvariants.length; i++) arrayForInvariants[firstArray[i]] = secondArray[i];

        return arrayForInvariants;
    }

    public static int[][] readMatrixFromFile(String fileName) throws FileNotFoundException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        int[][] matrix = null;
        try {
            String[] line = in.readLine().split(" ");
            int numRows = Integer.parseInt(line[0]);
            int numColumns = Integer.parseInt(line[1]);

            matrix = new int[numRows][numColumns];
            int i = 0;
            String lines = null;

            while ((lines = in.readLine()) != null) {
                String[] row = lines.split(" ");

                for (int j = 0; j < numColumns; j++) {
                    matrix[i][j] = Integer.parseInt(row[j + 1]);
                }
                i++;
                if (i == numRows) break;
            }
        } catch (IOException e) {

        }
        return matrix;
    }
}
