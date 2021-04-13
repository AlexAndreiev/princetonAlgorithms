package com.alex.andreiev;

public class BinarySearch {

    static int search(int[] array, int key){
        if (array.length == 0)
            return -1;
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low <= high)
        {
            mid = low + (high - low) / 2;
            int val = array[mid];
            if (val == key) return mid;
            if (val < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
