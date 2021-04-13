package com.alex.andreiev;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = Main.class.getResourceAsStream("/doubleData.txt");
        Scanner scanner = new Scanner(is);
        int N = scanner.nextInt();
        double arr[] = new double[N];
        int i = 0;
        while (scanner.hasNext())
            arr[i++] = scanner.nextDouble();

        for (double d : arr)
            System.out.println(d);
    }
}
