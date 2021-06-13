package com.alex.andreiev.utils;

import java.util.Comparator;

public class Utils {

    public static void exchange(Object[] arr, int i, int j){
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void exchange(Object i, Object j){
        Object tmp = i;
        i = j;
        j = tmp;
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public static boolean less(Comparator comparator, Object obj1, Object obj2){
        return comparator.compare(obj1, obj2) < 0;
    }

    public static boolean isSorted(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (Utils.less(arr[i], arr[i-1]))
                return false;
        return true;
    }
    public static boolean isSorted(Comparable[] arr, int start, int end)
    {
        for (int i = start; i < end; i++)
            if (Utils.less(arr[i], arr[i-1]))
                return false;
        return true;
    }
}
