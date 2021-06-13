package com.alex.andreiev.sorting;

import static com.alex.andreiev.utils.Utils.*;
/*
    Worst case performance O(n2)
    Best case performance O(n)
    Average case performance O(n2)
    Worst case space complexity O(n) total, O(1) auxiliary
    Stable
* */

public class BubbleSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (less(arr[j+1], arr[j]))
                    exchange(arr, j, j+1);
    }
}
