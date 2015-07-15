package com.mifasolla;

import java.util.ArrayList;

/**
 * Created by Vika on 13.07.2015.
 */
public class Heap {
    public ArrayList<Integer> array;
    private int heapSize;
    private boolean minHeap;
    private boolean maxHeap;

    private static int parent(int x) {
        return (x - 1)/2;
    }

    private static int left(int x) {
        return 2 * x + 1;
    }

    private static int right(int x) {
        return 2 * x + 2;
    }

    public Heap(ArrayList<Integer> array, boolean flag) {
        this.array = array;
        try {
            heapSize = this.array.size();
        } catch (NullPointerException e) {
            heapSize = -1;
        }
        if(flag){
            this.maxHeap = true;
            this.minHeap = false;
        } else {
            this.maxHeap = false;
            this.minHeap = true;
        }
    }

    public void buildMaxHeap(){
        for (int i = (this.array.size())/2; i >= 0; i--)
            this.maxHeapify(i);
    }

    public void buildMinHeap(){
        for (int i = (this.array.size()) / 2; i >= 0; i--)
            this.minHeapify(i);
    }

    private void maxHeapify(int x) {
        int l = left(x);
        int r = right(x);
        int largest;
        if(l < this.heapSize && this.array.get(l) > this.array.get(x)) {
            largest = l;
        } else {
            largest = x;
        }

        if(r < this.heapSize && this.array.get(r) > this.array.get(largest)) {
            largest = r;
        }

        if(largest != x) {
            int temp = this.array.get(x);
            this.array.set(x, this.array.get(largest));
            this.array.set(largest, temp);

            this.maxHeapify(largest);
        }
    }

    private void minHeapify(int x) {
        int l = left(x);
        int r = right(x);
        int smallest;
        if(l < this.heapSize && this.array.get(l) < this.array.get(x)) {
            smallest = l;
        } else {
            smallest = x;
        }

        if(r < this.heapSize && this.array.get(r) < this.array.get(smallest)) {
            smallest = r;
        }

        if(smallest != x) {
            int temp = this.array.get(x);
            this.array.set(x, this.array.get(smallest));
            this.array.set(smallest, temp);

            this.minHeapify(smallest);
        }
    }

    public void lowHeapSort() {
        this.buildMaxHeap();
        this.heapSize = this.array.size();

        for(int i = this.heapSize - 1; i > 0; i--) {
            int temp = this.array.get(0);
            this.array.set(0, this.array.get(i));
            this.array.set(i, temp);
            this.heapSize--;
            this.maxHeapify(0);
        }

       // this.heapSize = this.array.size();
    }

    public void highHeapSort() {
        this.buildMinHeap();
        this.heapSize = this.array.size();

        for(int i = this.heapSize - 1; i > 0; i--) {
            int temp = this.array.get(0);
            this.array.set(0, this.array.get(i));
            this.array.set(i, temp);
            this.heapSize--;
            this.minHeapify(0);
        }

      //  this.heapSize = this.array.size();
    }

    public void heapIncreaseKey(int x, int key) {
        this.array.set(x, key);
        if (maxHeap) {
            while (x > 0 && this.array.get(parent(x)) < this.array.get(x)) {
                int temp = this.array.get(x);
                this.array.set(x, this.array.get(parent(x)));
                this.array.set(parent(x), temp);

                x = parent(x);
            }
        } else {
            while (x > 0 && this.array.get(parent(x)) > this.array.get(x)) {
                int temp = this.array.get(x);
                this.array.set(x, this.array.get(parent(x)));
                this.array.set(parent(x), temp);

                x = parent(x);
            }
        }
    }

    public void heapInsert(int key) {
        this.array.add(null);
        this.heapSize = this.array.size();
        this.heapIncreaseKey(this.array.size() - 1, key);

    }

    public int heapExtractTopElement() {
        int extract = this.array.get(0);

        this.array.set(0, this.array.get(this.array.size() - 1));
        this.array.remove(this.array.size() - 1);
        this.heapSize = this.array.size();

        if(maxHeap) {
            this.maxHeapify(0);
        } else if(minHeap){
            this.minHeapify(0);
        }

        return extract;
    }

    public int heapTop(){
        try {
            return this.array.get(0);
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }



   /* public static void main(String[] args) {
        int [] array = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        ArrayList<Integer> A = addIntegerArrayToList(array);
        printList(A);

        Heap hs = new Heap(A);
        *//*hs.buildMaxHeap();
        hs.showArray();
        hs.buildMinHeap();
        hs.showArray();*//*

        hs.lowHeapSort();
        hs.showArray();
        hs.heapInsert(21);
        hs.showArray();
        hs.highHeapSort();
        hs.showArray();
        hs.heapInsert(20);
        hs.showArray();
        System.out.println(hs.heapExtractTopElement());
        hs.showArray();
        hs.lowHeapSort();
        hs.showArray();
        System.out.println("Heap size = " + hs.getHeapSize());
        System.out.println(hs.heapExtractTopElement());
        hs.showArray();



    }
*/

    public void showArray() {
        /*if(this.array.get(0) > this.array.get(1)) {
            System.out.println("maxHeapifyArray");
        } else {
            System.out.println("minHeapifyArray");
        }*/
        for(int i = 0; i < this.array.size(); i++) {
            System.out.print(this.array.get(i) + " ");
        }
        System.out.println();
    }

    public void showLeftChild(int x){
        System.out.println("Left child of array[x] is array["
                + left(x) + "] = " + this.array.get(left(x)));
    }

    public void showRightChild(int x){
        System.out.println("Right child of array[x] is array["
                + right(x) + "] = " + this.array.get(right(x)));
    }

    public void showParent(int x){
        System.out.printf("Parent of array[x] = %d is array[%d] = %d%n",
                this.array.get(x), parent(x), this.array.get(parent(x)));
    }

    public static ArrayList<Integer> addIntegerArrayToList(int []a) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 0; i < a.length; i++)
            arrayList.add(a[i]);

        return arrayList;
    }

    public static void printList(ArrayList<Integer> arrayList) {
        for(int i = 0; i < arrayList.size(); i++)
            System.out.print(arrayList.get(i) + " ");
        System.out.println();
    }

    public int getHeapSize() {
        return this.heapSize;
    }
}
