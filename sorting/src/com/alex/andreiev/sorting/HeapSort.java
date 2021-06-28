package com.alex.andreiev.sorting;
import static com.alex.andreiev.utils.Utils.*;

/*
* Basic plan for in-place sort:
*   - Create max-heap with all N keys
*   - Repeatedly remove the maximum key
* */

/*
Heap construction uses <= 2N compares and exchanges
Heapsort uses <= 2N lg N compares and exchanges

 In-place sorting algorithm with N log N worst-case
 - Mergesort: no, linear extra space - in-place merge possible, not practical
 - Quicksort: no, quadratic time in worst case - N log N worst-case quicksort possible, not practical
 - Heapsort - yes!
*/

/*
 Heapsort is optimal for both time and space, but:
 - inner loop longer than quicksort's
 - makes poor use of cache memory
 - Not stable
*/

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
        for (int k = (N-1)/2; k >= 0; k--) // N/2 - the last parent node
            sink(arr, k, N-1);
    }

    // remove the maximum, one at a time
    // leave in array, instead of nulling out
    private static void sortDown(Comparable[] arr){
        while(N > 1){
            exchange(arr, 0, N - 1);
            N--;
            sink(arr, 0, N - 1);
        }
    }

}
