package com.alex.andreiev.sorting;

import static com.alex.andreiev.utils.Utils.*;

import java.util.Random;

public class KnuthShuffle {

    public static void shuffle(Comparable[] arr){
        var r = new Random();
        for (int i = 1; i < arr.length; i++)
            exchange(arr, i, r.nextInt(i));
    }
}
