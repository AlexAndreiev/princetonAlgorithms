package com.alex.andreiev;

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
    private static boolean less(Comparator comparator, Object obj1, Object obj2){
        return comparator.compare(obj1, obj2) < 0;
    }
}
