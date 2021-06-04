package com.alex.andreiev.symbolTable;

import java.security.Key;

public class Utils {

    public static int rank(Comparable[] arr, Comparable key, int N){
        int lo = 0;
        int hi = N-1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(arr[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else    return mid;
        }
        return lo;
    }
}
