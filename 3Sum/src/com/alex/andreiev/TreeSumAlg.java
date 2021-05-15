package com.alex.andreiev;

public class TreeSumAlg {

    public static int BruteForce(int[] arr){
        int res = 0;
        for ( int i = 0; i < arr.length - 1; i++)
            for (int j = i+1; j < arr.length - 1; j++)
                for (int k = j + 1; k < arr.length - 1; k++)
                    if (arr[i] + arr[j] + arr[k] == 0)
                        res++;
        return res;
    }

    public static int SortingBased(int[] arr){
        //sorting-based algorithm
        //sort the N (disctinct) numbers.
        //for each pair of numbers a[i] and a[j], binary search for -(a[i] + a[j]).
        return 0;//stub

    }
}
