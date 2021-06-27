package com.alex.andreiev.sorting;
import static com.alex.andreiev.utils.Utils.*;

/* Invented by John von Neumann
* Java sort for objects
* Divide array into two halves
* Recursively sort each half
* Merge two halves
*
* Uses at most N lg N compares and 6N lg n array accesses to sort any array of size N
* Uses extra space proportional to N */

public class MergeSort {

    private static final int CUTOFF = 7;

    public static void sort(Comparable[] arr){
        int len = arr.length;
        var aux = new Comparable[len];
        //improvement3
        System.arraycopy(arr, 0, aux, 0, len);
        sort(arr, aux, 0, len -1);
    }

    /* Simple and non-recursive version of mergesort
    * (but about 10% slower than recursive, top-down mergesort on typical systems)
    * Basic plan
    * Pass through array, merging subarrays of size 1
    * Repeat for subarrays of size 2, 4, 8, 16, ... */
    public static void MergeBottomUp(Comparable[] arr){
        int len = arr.length;
        var aux = new Comparable[len];
        for (int sz = 1; sz < len; sz *= 2){
            for (int lo = 0; lo < len - sz; lo += sz*2) {
                var mid = lo + sz - 1;
                var hi = Math.min(lo + (sz * 2) - 1, len - 1);
                merge(arr, aux, lo, mid, hi);
            }
        }
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;
/*  improvement1
*   Use insertion sort for small subarrays
*    - Merge sort has too much overhead for tiny subarrays
*    - Cutoff to insertion sort for 7 items
*
*        if (hi <= lo + CUTOFF - 1){
*            Insertion(arr, lo, hi);
*            return;
*        }
*/

        int mid = lo + (hi-lo) /2;
//        sort(arr, aux, lo, mid);
//        sort(arr, aux, mid+1, hi);
        // improvement3
        sort(aux, arr, lo, mid);        // Note: sort(a) initializes aux[] and sets
        sort(aux, arr, mid+1, hi);  // aux[i] = a[i] for each i
/*
*   improvement2 - Stop if already sorted
*     - Is biggest item in first half <= smallest item in second half?
*     - Helps for partially-ordered arrays
*
*       if (!less((arr[mid+1]), arr[mid])) return;
*/

 /* improvement3 - Eliminate the copy to the auxiliary array.
 *  Save time (but not space) by switching the role of the input and auxiliary array in each recursive call.
 */
        mergeOptimazed(aux, arr, lo, mid, hi);
//        merge(arr, aux, lo, mid, hi);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid); // precondition a[lo..mid] sorted
        assert isSorted(a, mid+1, hi); // precondition a[mid+1..hi] sorted
        if (hi + 1 - lo >= 0)
            System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

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
}
