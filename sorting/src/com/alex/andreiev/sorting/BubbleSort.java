package com.alex.andreiev.sorting;

import com.alex.andreiev.utils.Utils;

public class BubbleSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (Utils.less(arr[j+1], arr[j]))
                    Utils.exchange(arr, j, j+1);
    }
}
