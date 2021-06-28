package com.alex.andreiev.utils;

import java.util.Comparator;
import java.util.Random;

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

    public static boolean less(Comparator comparator, Object obj1, Object obj2){
        return comparator.compare(obj1, obj2) < 0;
    }

    public static boolean isSorted(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (Utils.less(arr[i], arr[i-1]))
                return false;
        return true;
    }
    public static boolean isSorted(Comparable[] arr, int start, int end)
    {
        for (int i = start; i < end; i++)
            if (Utils.less(arr[i], arr[i-1]))
                return false;
        return true;
    }

    public static void shuffleArr(Comparable[] arr){
        var rand = new Random();
        for (int i = 0; i < arr.length; i++){
            int randIndexTpSwap = rand.nextInt(arr.length);
            Comparable temp = arr[randIndexTpSwap];
            arr[randIndexTpSwap] = arr[i];
            arr[i] = temp;
        }
    }

    /* Promotion in a heap
    * Scenario. Child's key becomes larger key than its parent's key
    * To eliminate the violation:
    *   - Exchange key in child with key in parent
    *   - Repeat until heap order restored
    * Peter principle. Node promoted to level of incompetence
    * */
    public static void swim(Comparable[] arr, int k){
        while (k > 1 && less(arr[k/2], arr[k])){    // parent of node at k is at k/2
            exchange(arr, k, k/2);
            k = k/2;
        }
    }


    /* Demotion in a heap
    * Scenario. Parent's key becomes smaller than one (or both) of its children's
    * To eliminate the violation:
    *   - Exchange key in parent with key in larger child
    *   - Repeat until heap order restored
    * Power struggle. Better subordinate promoted
    * */
    public static void sink(Comparable[] arr, int k, int N) {
        while (2*k <= N)
        {
            int j = 2*k;
            //grab larger child
            if (j<N && less(arr[j], arr[j+1]))  // children of node at k are 2k and 2k+1
                j++;
            if (!less(arr[k], arr[j])) break;
            exchange(arr, k, j);
            k = j;
        }
    }

}
