package com.alex.andreiev.sorting;

import java.util.Random;

import static com.alex.andreiev.utils.Utils.*;

public class SortingAlgorithms {
    private static final int CUTOFF = 7;

    private static int partition(Comparable[] arr, int lo, int hi){
        int i = lo, j = hi+1;
        while (true){
            while (less(arr[++i], arr[lo])) // find item on left swap
                if (i == hi) break;

            while (less(arr[lo], arr[--j])) // find item on right to swap
                if (j == lo) break;

            if (i >= j) break; // check if pointers cross
            exchange(arr, i, j); // swap
        }
        exchange(arr, lo, j); // swap with partitioning item
        return j;   // return index of item now know to be in place
    }

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

    public static void QuickSort(Comparable[] arr){
        // shuffle needed for performance guarantee
        // probabilistic guarantee against worst case
        // basic for math model that can be validated with experiments
        shuffleArr(arr);
        sortQuickSort(arr, 0, arr.length-1);
    }
    private static void sortQuickSort(Comparable[] arr, int lo, int hi){
        if (hi <= lo) return;
//         improvement1
//        Even quick sort has too much overhead for tiny subarrays
//        Cutoff to insertion sort for ~ 10 items
//        Note: could delay insertion sort until one pass at end
//        if (hi <= lo + CUTOFF - 1){
//            Insertion(arr, lo, hi);
//            return;
//        }

//        improvement2
//        Best choice of pivot item = median
//        Estimate true median by taking median of sample
//        Median-of-3 (random) items:
//              12/7: N in N compares (slightly fewer)
//              12/35 N in N exchanges (slightly more)
//        int m = medianOf(a, lo, lo + (hi-lo)/2, hi);
//        exchange(arr, lo, m);

//improvement3 - effective with duplicates
/*
        var threeWayPart = ThreeWayPartition(arr, lo, hi);
        sortQuickSort(arr, lo, threeWayPart.lt - 1);
        sortQuickSort(arr, threeWayPart.gt + 1, hi);
*/
        int j = partition(arr, lo, hi);
        sortQuickSort(arr, lo, j-1);
        sortQuickSort(arr, j+1, hi);
    }

    private static void shuffleArr(Comparable[] arr){
        var rand = new Random();
        for (int i = 0; i < arr.length; i++){
            int randIndexTpSwap = rand.nextInt(arr.length);
            Comparable temp = arr[randIndexTpSwap];
            arr[randIndexTpSwap] = arr[i];
            arr[i] = temp;
        }
    }

    public static Comparable Select(Comparable[] arr, int k){
        shuffleArr(arr);
        int lo = 0, hi = arr.length - 1;
        while(hi > lo){
            int j = partition(arr, lo, hi);
            if (j < k)      lo = j + 1;
            else if (j > k) hi = j - 1;
            else            return arr[k];
        }
        return arr[k];
    }
}

class ThreeWayPart{
    public int lt, gt;
}