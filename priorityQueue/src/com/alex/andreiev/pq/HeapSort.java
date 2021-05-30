package com.alex.andreiev.pq;
import com.alex.andreiev.utils.Utils;

// In-place sorting algorithm with N log N worst-case
// - Mergesort: no, linear extra space - in-place merge possible, not practical
// - Quicksort: no, quadratic time in worst case - N log N worst-case quicksort possible, not practical
// - Heapsort - yes!

// Heapsort is optimal for both rime and space, but:
// - inner loop longer than quicksort's
// - makes poor use of cache memory
// - Not stable

//NOTE: NEEDS the conversion from 1-based indexing to 0-base indexing
public class HeapSort {

    private static int N = 0;

    public static void sort(Comparable[] arr){
        N = arr.length;
        heapConstruction(arr);
        sortDown(arr);
    }

    // build heap using bottom-up method
    private static void heapConstruction(Comparable[] arr){
        for (int k = N/2; k >= 1; k--)
            com.alex.andreiev.pq.Utils.sink(arr, k, N);
    }

    // remove the maximum, one at a time
    // leave in array, instead of nulling out
    private static void sortDown(Comparable[] arr){
        while(N > 1){
            Utils.exchange(arr, 1, N--);
            com.alex.andreiev.pq.Utils.sink(arr, 1, N);
        }
    }

}
