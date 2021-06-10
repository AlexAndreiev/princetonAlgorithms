package com.alex.andreiev.sorting;

import com.alex.andreiev.utils.Utils;
import java.util.Comparator;

/*
    To sort a randomly-order array with distinct keys, insertion sort uses ~1/4N2 compares and ~1/4N2 exchanges on average
    Worst case performance O(n2)
    Best case performance O(n)
    Average case performance O(n2)
    Worst case space complexity O(n) total, O(1) auxiliary
    Stable
* */

public class InsertionSort {

    public static void sort(Comparable[] arr, int lo, int hi){
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0; j--) {
                if (Utils.less(arr[j], arr[j-1]))
                    Utils.exchange(arr, j, j-1);
                else break;
            }
        }
    }

    public static void sort(Object[] arr, int lo, int hi, Comparator comparator){
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > 0; j--)
                if (Utils.less(comparator, arr[j], arr[j-1]))
                    Utils.exchange(arr, j, j-1);
                else break;
    }
}
