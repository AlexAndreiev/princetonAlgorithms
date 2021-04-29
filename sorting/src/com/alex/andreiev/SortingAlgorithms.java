package com.alex.andreiev;

import java.util.Random;
import java.util.TreeMap;

public class SortingAlgorithms {

    public static void Selection(Comparable[] arr){
        int len = arr.length;
        int i = 0;
        while (i < len-1){
            int min = i;
            for (int j = i+1; j < len; j++)
                if (less(arr[j], arr[min]))
                    min = j;
            exchange(arr, i, min);
            i++;
        }
    }

    public static void Insertion(Comparable[] arr){
        for (int i = 1; i < arr.length; i++)
            for (int j=i; j > 0; j--)
                if (less(arr[j], arr[j-1]))
                    exchange(arr, j, j-1);
                else break;
    }

    public static void Shell(Comparable[] arr){
        int N = arr.length;
        int h = 1;
        while (h < N/3)
            h = 3*h + 1; // 1, 4, 13, 20,121, 364, ...
        while (h >= 1)
        {// h-sort the array
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && less(arr[j], arr[j-h]); j -= h) {
                    exchange(arr, j, j - h);
                }
            }
            h = h/3;
        }
    }

    public static void KnuthShuffle(Comparable[] arr){
        var r = new Random();
        for (int i = 1; i < arr.length; i++)
            exchange(arr, i, r.nextInt(i));
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
