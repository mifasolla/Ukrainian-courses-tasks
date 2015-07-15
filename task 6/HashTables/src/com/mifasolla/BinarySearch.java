package com.mifasolla;

import java.util.ArrayList;

/**
 * Created by Vika on 15.07.2015.
 */
public class BinarySearch {

    public static boolean binaryCheckExistence(long x, ArrayList<Long> A, int p, int r) {

        if(A.get(p) > x || A.get(r) < x) return false;

        int index;
        boolean result = false;

        if((p + r) % 2 == 0) index = (p + r) / 2;
        else index = (p + r) / 2 + 1;

        if(x == A.get(index)) {
            return true;
        } else if(x > A.get(index)){
            result = binaryCheckExistence(x, A, index + 1, r);
        } else {
            result = binaryCheckExistence(x, A, p, index - 1);
        }

        return result;
    }


    public static void main(String[] args) {
        long[] A1 = new long []{100,
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

        ArrayList<Long> A = new ArrayList<Long>();
        for(int i = 0; i < A1.length; i++) {
            A.add(A1[i]);
        }
        QuickSortSolution.quickSortArrayList(A, 0, A.size() - 1);

        System.out.println(binaryCheckExistence(100, A, 0, A.size() - 1));
        System.out.println(binaryCheckExistence(87, A, 0, A.size() - 1));
        System.out.println(binaryCheckExistence(12, A, 0, A.size() - 1));
        System.out.println(binaryCheckExistence(-100, A, 0, A.size() - 1));
        System.out.println(binaryCheckExistence(0, A, 0, A.size() - 1));
        System.out.println(binaryCheckExistence(101, A, 0, A.size() - 1));
    }
}
