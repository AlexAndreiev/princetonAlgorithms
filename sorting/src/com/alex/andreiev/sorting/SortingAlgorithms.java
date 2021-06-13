package com.alex.andreiev.sorting;

import com.alex.andreiev.utils.Utils;

import java.util.Comparator;
import java.util.Random;

public class SortingAlgorithms {
    private static final int CUTOFF = 7;

    public static void MergeSort(Comparable[] arr){
        int len = arr.length;
        var aux = new Comparable[len];
        //improvement3
        for (int i = 0; i < len; i++)
            aux[i] = arr[i];
        sort(arr, aux, 0, len -1);
    }

    public static void MergeBottomUp(Comparable[] arr){
        int len = arr.length;
        var aux = new Comparable[len];
        for (int sz = 1; sz < len; sz *= 2){
            for (int lo = 0; lo < len - sz; lo += sz*2)
               merge(arr, aux, lo, lo + sz-1, Math.min(lo+(sz*2)-1, len-1));
        }
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
//         improvement1
//        if (hi <= lo + CUTOFF - 1){
//            Insertion(arr, lo, hi);
//            return;
//        }
        //----
        int mid = lo + (hi-lo) /2;
//        sort(arr, aux, lo, mid);
//        sort(arr, aux, mid+1, hi);
        // improvement3
        sort(aux, arr, lo, mid);        // Note: sort(a) initializes aux[] and sets
        sort(aux, arr, mid+1, hi);  // aux[i] = a[i] for each i
        // improvement2
//        if (!less((arr[mid+1]), arr[mid])) return;
        //----
//        merge(arr, aux, lo, mid, hi);
        //improvement3
        mergeOptimazed(aux, arr, lo, mid, hi);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid); // precondition a[lo..mid] sorted
        assert isSorted(a, mid+1, hi); // precondition a[mid+1..hi] sorted
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (Utils.less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
        assert isSorted(a, lo, hi);
    }

    public static void mergeOptimazed(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid); // precondition a[lo..mid] sorted
        assert isSorted(a, mid+1, hi); // precondition a[mid+1..hi] sorted
        int i = lo;
        int j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid)                    aux[k] = a[j++];
            else if (j > hi)                aux[k] = a[i++];
            else if (Utils.less(a[j], a[i]))      aux[k] = a[j++];
            else                            aux[k] = a[i++];
        }
        assert isSorted(a, lo, hi);
    }

    private static boolean isSorted(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (Utils.less(arr[i], arr[i-1]))
                return false;
        return true;
    }
    private static boolean isSorted(Comparable[] arr, int start, int end)
    {
        for (int i = start; i < end; i++)
            if (Utils.less(arr[i], arr[i-1]))
                return false;
        return true;
    }

    private static int partition(Comparable[] arr, int lo, int hi){
        int i = lo, j = hi+1;
        while (true){
            while (Utils.less(arr[++i], arr[lo])) // find item on left swap
                if (i == hi) break;

            while (Utils.less(arr[lo], arr[--j])) // find item on right to swap
                if (j == lo) break;

            if (i >= j) break; // check if pointers cross
            Utils.exchange(arr, i, j); // swap
        }
        Utils.exchange(arr, lo, j); // swap with partitioning item
        return j;   // return index of item now know to be in place
    }

    private static ThreeWayPart ThreeWayPartition(Comparable[] arr, int lo, int hi){
        int lt = lo, gt = hi;
        Comparable v = arr[lo];
        int i = lo;
        while(i <= gt){
            int cmp = arr[i].compareTo(v);
            if (cmp < 0)        Utils.exchange(arr, lt++, i++);
            else if (cmp > 0)   Utils.exchange(arr, i, gt--);
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
//        var threeWayPart = ThreeWayPartition(arr, lo, hi);
//        sortQuickSort(arr, lo, threeWayPart.lt - 1);
//        sortQuickSort(arr, threeWayPart.gt + 1, hi);
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