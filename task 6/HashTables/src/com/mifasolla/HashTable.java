package com.mifasolla;

import java.util.ArrayList;

/**
 * Created by Vika on 14.07.2015.
 */
public class HashTable {

    private long[] dataArray;
    private ArrayList<Long>[] hashList;
    final private  int ALPHA = 3;

    public HashTable(long [] dataArray) {
        this.dataArray = dataArray;
        hashList = new ArrayList[this.dataArray.length/ALPHA];
        for(int i = 0; i < hashList.length; i++) {
            hashList[i] = new ArrayList<Long>();
        }
    }

    public void createHashList() {
        for(int i = 0; i < dataArray.length; i++){
            int h = hashFunction(dataArray[i]);
            hashList[h].add(dataArray[i]);
        }

        for(int i = 0; i < hashList.length; i++) {
            QuickSortSolution.quickSortArrayList(hashList[i], 0, hashList[i].size() - 1);
        }
    }

    private int hashFunction(long k){
        if(k > 0) return (int)(k % hashList.length);
        else return (int)((k % hashList.length)*(-1));
    }

    public boolean hashListConsist(long k) {
        int hf = hashFunction(k);
       /* if(hashList[hf].size() > 0) {
            int i = 0;
            while (i < hashList[hf].size()) {
                if(hashList[hf].get(i) == k)
                    return true;
                i++;
            }
        }
        return false; */
        if (hashList[hf].size() < 1) {
            return false;
        } else {
            return BinarySearch.binaryCheckExistence(k, hashList[hf], 0, hashList[hf].size() - 1);
        }
    }


    public static void main(String[] args) {
        long [] data = new long[] {1, 2, 3, 4, 5, 6, 23, 45, 21};

        HashTable ht = new HashTable(data);
        ht.createHashList();
        System.out.println(ht.hashListConsist(22));
        System.out.println(ht.hashListConsist(3));
        System.out.println(ht.hashListConsist(21));
        System.out.println(ht.hashListConsist(43));
        System.out.println(ht.hashListConsist(44));
        System.out.println(ht.hashListConsist(45));

    }


}
