package com.alex.andreiev.sorting;

import com.alex.andreiev.dynConnectivity.QuickFindUF;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Path.of("./resources/tinyUF.txt"));
        int N = scanner.nextInt();
        QuickFindUF uf = new QuickFindUF(N);
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
   }
}

