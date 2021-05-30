package com.alex.andreiev.pq;

public class Utils {
    public static void swim(Comparable[] arr, int k){
        while (k > 1 && com.alex.andreiev.utils.Utils.less(arr[k/2], arr[k])){
            com.alex.andreiev.utils.Utils.exchange(arr, k, k/2);
            k = k/2;
        }
    }

    public static void sink(Comparable[] arr, int k, int N) {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j<N && com.alex.andreiev.utils.Utils.less(arr[j], arr[j+1]))
                j++;
            if (!com.alex.andreiev.utils.Utils.less(arr[k], arr[j])) break;
            com.alex.andreiev.utils.Utils.exchange(arr, k, j);
            k = j;
        }
    }

}
