package com.alex.andreiev.pq;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = MaxPQ.class.getResourceAsStream("/tinyBatch.txt");
        int M = 5;
        var unorderQueue = new UnorderedMaxPQ<Transaction>(20); // Transaction data type is Comparable (ordered by $$)
        var binaryQueue = new MaxPQ<Transaction>(20); // Transaction data type is Comparable (ordered by $$)
        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Transaction item = new Transaction(line);

            Transaction tmp = null;
            unorderQueue.insert(item);
            if (unorderQueue.size() > M) // queue contains largest M items
                tmp = unorderQueue.delete();

            binaryQueue.insert(item);
            if (binaryQueue.size() > M) // queue contains largest M items
                tmp = binaryQueue.delete();

            if (tmp != null)
                tmp.toString();
        }

        System.out.println("-----Unordered priority queue-----");
        while (unorderQueue.size() > 0)
            System.out.println(unorderQueue.delete().toString());

        System.out.println("-----Ordered binary priority queue-----");
        while (binaryQueue.size() > 0)
            System.out.println(binaryQueue.delete().toString());
    }
}
