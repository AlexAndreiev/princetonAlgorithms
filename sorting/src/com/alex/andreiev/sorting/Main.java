package com.alex.andreiev.sorting;

import java.util.Random;

/*
* Computational complexity. Framework to study efficiency of algorithms for solving a particular problem x.
* Model of computation. Allowable operations.
* Cost model. Operation counts
* Upper bound. Cost guarantee provided by some algorithm for X.
* Lower bound. Proven limit on const guarantee of all algorithms for X
* Optimal algorithm. Algorithm wih best possible cost guarantee for X. Lower bound ~ upper bound.
*
* A STABLE sort preserves the relative order of items with equal keys.
* */

public class Main {

    public static void main(String[] args) {
//        InputStream is = Main.class.getResourceAsStream("/doubleData.txt");
//        Scanner scanner = new Scanner(is);
//        int N = scanner.nextInt();
        int N = 6;
        Double[] arr = new Double[N];
        int rangeMin = 0;
        int rangeMax = 100;
        var randomized = new Random();
        for (int i = 0; i < N; i++)
            arr[i] = (rangeMax - rangeMin) * randomized.nextDouble() + rangeMin;
        //        SelectionSort.sort(arr);
//        InsertionSort.sort(arr, 0, arr.length-1);
//        SortingAlgorithms.QuickSort(arr);
//        BubbleSort.sort(arr);
//        ShellSort.sort(arr);
        QuickSort.threeWaySort(arr);
        for (double d : arr)
            System.out.println(d);
//        double max = (double) SortingAlgorithms.Select(arr, arr.length-3);
//        System.out.println("3rd max = " + max);
    }
}
