package com.alex.andreiev.sorting;

/* Invented in 1959
    Move entries more than one position at a time by h-sorting the array
*   Why insertion sort?
        - Big increments -> small subarray
        - Small increments -> nearly in order
    The worst case number if compares used by shellsort with the 3x+1 increments is O(N^(3/2))
    Fast unless array size is huge (used for small subarrays)
    Tiny, fixed footprint for code (used in some embedded systems
    Hardware sort prototype
* */

import com.alex.andreiev.utils.Utils;

public class ShellSort {

    public static void sort(Comparable[] arr){
        int N = arr.length;
        int h = 1;
        while (h < N/3) //Knut
            h = 3*h + 1; // 1, 4, 13, 20,121, 364, ...   3x+1 increment sequence
        while (h >= 1)
        {// h-sort the array
            for (int i = h; i < N; i++)        // insertion sort
            {
                for (int j = i; j >= h && Utils.less(arr[j], arr[j - h]); j -= h)
                    Utils.exchange(arr, j, j - h);
            }
            h = h/3;        //move to the next increment
        }
    }
}
