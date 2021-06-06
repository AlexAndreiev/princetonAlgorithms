package com.alex.andreiev.sorting;

import com.alex.andreiev.utils.Utils;

// Selection sort uses (N-1) + (N-2) + ... + 1 + 0 ~ N2/2 compares and N exchanges
// Running time insensitive to input. Quadratic time, even if input is sorted
// Data movements is minimal. Linear number of exchanges
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
