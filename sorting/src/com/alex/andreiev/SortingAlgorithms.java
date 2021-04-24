package com.alex.andreiev;

import java.util.TreeMap;

public class SortingAlgorithms {

    public static void Bubble(Comparable[] arr){
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j > 0; j--)
                if (arr[j].compareTo(arr[j-1]) < 0)
                    exchange(arr, j, j-1);
                else break;
    }

    public static void Insertion(Comparable[] arr){

    }

    private  static void exchange(Comparable[] arr, int i, int j){
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private  static boolean isSorted(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (less(arr[i], arr[i-1]))
                return false;
        return true;
    }
}
