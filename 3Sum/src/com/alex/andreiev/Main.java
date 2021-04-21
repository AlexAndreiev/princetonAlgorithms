package com.alex.andreiev;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = TreeSumAlg.class.getResourceAsStream("/data.txt");
        Scanner scanner = new Scanner(is);
        int N = scanner.nextInt();
        int arr[] = new int[N];
        int i = 0;
        while (scanner.hasNext())
            arr[i++] = scanner.nextInt();
        int res = TreeSumAlg.BruteForce(arr);
        System.out.println("Triple sums equal zero: " + res);
    }
}
