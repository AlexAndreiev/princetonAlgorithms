package com.alex.andreiev.dynConnectivity;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var stream = Main.class.getResourceAsStream("/tinyUF.txt");
        Scanner scanner = new Scanner(Objects.requireNonNull(stream));
         int N = scanner.nextInt();
//        var uf = new QuickFindUF(N);
//        var uf = new QuickUnion(N);
        var uf = new WeightedQuickUnion(N);
        while (scanner.hasNext())
        {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
        System.out.println(uf.count());
   }
}

