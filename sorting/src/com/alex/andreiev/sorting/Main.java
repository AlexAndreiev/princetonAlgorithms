package com.alex.andreiev.sorting;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        InputStream is = Main.class.getResourceAsStream("/doubleData.txt");
//        Scanner scanner = new Scanner(is);
//        int N = scanner.nextInt();
        int N = 6;
        Double arr[] = new Double[N];
        int rangeMin = 0;
        int rangeMax = 100;
        var randomized = new Random();
        for (int i = 0; i < N; i++)
            arr[i] = (rangeMax - rangeMin) * randomized.nextDouble() + rangeMin;
//        SortingAlgorithms.Insertion(arr, 0, arr.length-1);
        SortingAlgorithms.QuickSort(arr);
        for (double d : arr)
            System.out.println(d);
//        double max = (double) SortingAlgorithms.Select(arr, arr.length-3);
//        System.out.println("3rd max = " + max);
    }
}
