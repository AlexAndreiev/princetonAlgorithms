package com.alex.andreiev.sorting;

import com.alex.andreiev.utils.Utils;

/*
 Selection sort uses (N-1) + (N-2) + ... + 1 + 0 ~ N2/2 compares and N exchanges
 Running time insensitive to input. Quadratic time, even if input is sorted
 Data movements is minimal. Linear number of exchanges
    Worst case performance O(n2)
    Best case performance O(n2)
    Average case performance O(n2)
    Worst case space complexity O(n) total, O(1) auxiliary
    Not stable

    Selection sort always performs O(n) swaps, while insertion sort performs O(n2) swaps in the average and worst case.
    Selection sort is preferable if writing to memory is significantly more expensive than reading.
* */
public class SelectionSort {

    public static void sort(Comparable[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (Utils.less(arr[j], arr[min]))
                    min = j;
            }
            Utils.exchange(arr, i, min);
        }
    }
}
