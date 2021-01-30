package com.alex.andreiev;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

class DynConnClient {
    public static void main(String[] args){
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Scanner scanner = null;
        try {
            scanner = new Scanner(Path.of("./resources/tinyUF.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        var scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        var uf = new QuickFindUF(N);
        while (scanner.hasNextInt())
        {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                System.out.println(p + "" + q);
            }

        }

    }
}