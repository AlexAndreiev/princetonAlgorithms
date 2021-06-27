package com.alex.andreiev.sorting;

/* Invented by Sir Charles Antony Richard Hoare - 1980 Turing Award
* Basic plan
* 1 Shuffle the array
* 2 Partition so that, for some j:
*   - entry a[j] is in place
*   - no larger entry to the left of j
*   - no smaller entry to the right of j
* 3. Sort each piece recursively
* */

/* Implementation details
*  Partitioning in-place. Using an extra array makes partitioning easier (and stable), but is not worth the cost.
* Terminating the loop. Testing whether the pointers cross is a bit trickier than it might seem
* Staying in bounds. The (j == lo) test is redundant (why?), but the (i == hi) test is not.
* Preserving randomness. Shuffling is needed for performance guarantee.
* Equal keys. When duplicates are present, it is (counter-intuitively) better to stop on keys to the partitioning item's key
*
* Average - O(n log n) - 1.39N lg N
* Worst case (without shuffling) - O(n^2)
* no extra space usage
*
* 39% more compares than mergesort
* But faster than mergesort in practice because of less data movement
*
* IS NOT STABLE
* */

import static com.alex.andreiev.utils.Utils.*;

public class QuickSort {

    private static final int CUTOFF = 7;

    public static void sort(Comparable[] arr){
/*       shuffle needed for performance guarantee
         probabilistic guarantee against worst case
         basic for math model that can be validated with experiments
*/
        shuffleArr(arr);
        sort(arr, 0, arr.length-1);
    }

    public static void threeWaySort(Comparable[] arr){
/*       shuffle needed for performance guarantee
         probabilistic guarantee against worst case
         basic for math model that can be validated with experiments
*/
        shuffleArr(arr);
        threeWaySort(arr, 0, arr.length-1);
    }


    private static void sort(Comparable[] arr, int lo, int hi){
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

        int j = partition(arr, lo, hi);
        sort(arr, lo, j-1);
        sort(arr, j+1, hi);
    }


    private static int partition(Comparable[] arr, int lo, int hi){
        int i = lo, j = hi+1;
        while (true) {
            while (less(arr[++i], arr[lo])) // find item on left swap
                if (i  ==hi) break;

            while (less(arr[lo], arr[--j])) // find item on right to swap
                if (j == lo) break;

            if (i >= j) break; // check if pointers cross
            exchange(arr, i, j); // swap
        }
        exchange(arr, lo, j); // swap with partitioning item
        return j;   // return index of item now know to be in place
    }

    /* Goal. Given an array of N items, find the kth largest
     * Ex. Min (k=0), max(k=N-1), median (K = N/2)
     * Applications:
     *   Order statistics
     *   Find the "top k"
     *
     * Use theory as a guide:
     *   Easy N log N upper bound.
     *   Easy N upper bound for k = 1, 2, 3
     *   Easy N lower bound.
     *
     * Partition array so that:
     *   Entry a[j] is in place
     *   No larger entry to the left of j
     *   No smaller entry to the right of j
     * Repeat in one subarray, depending on j; finished when j equals k
     *
     * Takes linear time on overage
     * */
    public static Comparable QuickSelect(Comparable[] arr, int k){
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

    /* Goal. Partition array into 3 parts so that:
    *  - Entries between lt and gt equal to partition item v
    *  - No larger entries to left of lt
    *  - No smaller entries to right of gt
    * */
    /*
        improvement3 - effective with duplicates
         - stop scans on items equal to the partitioning item

        var threeWayPart = ThreeWayPartition(arr, lo, hi);
        sort(arr, lo, threeWayPart.lt - 1);
        sort(arr, threeWayPart.gt + 1, hi);
*/
    private static void threeWaySort(Comparable[] arr, int lo, int hi){
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = arr[lo];
        int i = lo;
        while(i <= gt){
            int cmp = arr[i].compareTo(v);
            if (cmp < 0)        exchange(arr, lt++, i++);
            else if (cmp > 0)   exchange(arr, i, gt--);
            else                i++;
        }

        threeWaySort(arr, lo, lt -1);
        threeWaySort(arr, gt + 1, hi);
    }
}
