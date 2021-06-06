package com.alex.andreiev.sorting;

import com.alex.andreiev.utils.Utils;
import java.util.Comparator;

// To sort a randomly-order array with distinct keys, insertion sort uses ~1/4N2 compares and ~1/4N2 exchanges on average
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
