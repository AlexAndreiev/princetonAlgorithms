package com.alex.andreiev.sorting;

import static com.alex.andreiev.utils.Utils.*;

/*
 Selection sort uses (N-1) + (N-2) + ... + 1 + 0 ~ (N^2)/2 compares and N exchanges
 Running time insensitive to input. Quadratic time, even if input is sorted
 Data movements is minimal. Linear number of exchanges
    Worst case performance O(N^2)
    Best case performance O(N^2)
    Average case performance O(N^2)
    Worst case space complexity O(N) total, O(1) auxiliary
    Not stable

    Selection sort always performs O(N) swaps, while insertion sort performs O(N^2) swaps in the average and worst case.
    Selection sort is preferable if writing to memory is significantly more expensive than reading.
* */
public class SelectionSort {

    public static void sort(Comparable[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(arr[j], arr[min]))
                    min = j;
            }
            exchange(arr, i, min);
        }
    }
}
