package com.alex.andreiev.sorting;

import static com.alex.andreiev.utils.Utils.*;
import java.util.Comparator;

/*
    To sort a randomly-order array with distinct keys, insertion sort uses ~(1/4)*N^2 compares and ~(1/4)*N^2 exchanges on average
    Worst case performance O(N^2)
    Best case performance O(N^)
    Average case performance O(N^2)
    Worst case space complexity O(N) total, O(1) auxiliary
    Stable
* */

public class InsertionSort {

    public static void sort(Comparable[] arr, int lo, int hi){
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j-1]))
                    exchange(arr, j, j-1);
                else break;
            }
        }
    }

    public static void sort(Object[] arr, int lo, int hi, Comparator comparator){
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > 0; j--)
                if (less(comparator, arr[j], arr[j-1]))
                    exchange(arr, j, j-1);
                else break;
    }
}
