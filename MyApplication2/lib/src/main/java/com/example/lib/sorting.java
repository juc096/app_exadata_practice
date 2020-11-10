package com.example.lib;

import java.util.Arrays;

public class sorting {
    public String bubbleSort(int a[]) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (a[j] > a[j+1]) {
                    //swap
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return Arrays.toString(a);
    }

    public void quickSort(int a[]) {
        //findmedian
        //reconstruct array
        //finally join
    }
    /*
        insertion sort!
        Time Complexity: O(n^2)
        Space Complexity: O(n)
     */
    public String insertionSort(int a[]) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            int key = a[i];
            for (int j = i-1; j >= 0; j--) {
                if (key < a[j]) {
                    a[j + 1] = a[j];
                    a[j] = key;
                }
            }
        }
        return Arrays.toString(a);
    }
    public static void main(String[] args) {
        int a[] = {10, 3, 2, 40, 22, 17};
        int b[] = {12, 11, 13, 5,6};
        sorting ex = new sorting();
        ex.bubbleSort(a);
        ex.insertionSort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }
}