package com.alex.andreiev;

import java.util.Collection;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeMap;

public class SortingAlgorithms {
    private static final int CUTOFF = 7;

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

    public static void Insertion(Comparable[] arr, int lo, int hi){
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > 0; j--)
                if (less(arr[j], arr[j-1]))
                    exchange(arr, j, j-1);
                else break;
    }
    public static void Insertion(Object[] arr, int lo, int hi, Comparator comparator){
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > 0; j--)
                if (less(comparator, arr[j], arr[j-1]))
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
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
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
            else if (less(a[j], a[i]))      aux[k] = a[j++];
            else                            aux[k] = a[i++];
        }
        assert isSorted(a, lo, hi);
    }

    public static void KnuthShuffle(Comparable[] arr){
        var r = new Random();
        for (int i = 1; i < arr.length; i++)
            exchange(arr, i, r.nextInt(i));
    }

    private static void exchange(Object[] arr, int i, int j){
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static boolean less(Comparator comparator, Object obj1, Object obj2){
        return comparator.compare(obj1, obj2) < 0;
    }

    private static boolean isSorted(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (less(arr[i], arr[i-1]))
                return false;
        return true;
    }
    private static boolean isSorted(Comparable[] arr, int start, int end)
    {
        for (int i = start; i < end; i++)
            if (less(arr[i], arr[i-1]))
                return false;
        return true;
    }

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

    public static void QuickSort(Comparable[] arr){
        // shuffle needed for performance guarantee
        // probabilistic guarantee against worst case
        // basic for math model that can be validated with experiments
        shuffleArr(arr);
        sortQuickSort(arr, 0, arr.length-1);
    }
    private static void sortQuickSort(Comparable[] arr, int lo, int hi){
        if (hi <= lo) return;
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

}
