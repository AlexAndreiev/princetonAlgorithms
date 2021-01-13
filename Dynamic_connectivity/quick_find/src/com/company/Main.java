package com.company;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
//        URL url = ClassLoader.class.getResource("tinyUF.txt");
//        ResourceBundle bundle = ResourceBundle.getBundle("tinyUF.txt");
        Scanner scanner = new Scanner(Path.of("./resources/tinyUF.txt"));
        int N = scanner.nextInt();
        QuickFindUF uf = new QuickFindUF(N);
        while (scanner.hasNext())
        {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (!uf.equals(p, q))
            {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
   }
}

