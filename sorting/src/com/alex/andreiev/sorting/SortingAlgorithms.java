package com.alex.andreiev.sorting;

import java.util.Random;

import static com.alex.andreiev.utils.Utils.*;

public class SortingAlgorithms {
    private static final int CUTOFF = 7;

    private static ThreeWayPart ThreeWayPartition(Comparable[] arr, int lo, int hi){
        int lt = lo, gt = hi;
        Comparable v = arr[lo];
        int i = lo;
        while(i <= gt){
            int cmp = arr[i].compareTo(v);
            if (cmp < 0)        exchange(arr, lt++, i++);
            else if (cmp > 0)   exchange(arr, i, gt--);
            else                i++;
        }
        var res = new ThreeWayPart();
        res.lt = lt;
        res.gt = gt;
        return res;
    }

}

class ThreeWayPart{
    public int lt, gt;
}