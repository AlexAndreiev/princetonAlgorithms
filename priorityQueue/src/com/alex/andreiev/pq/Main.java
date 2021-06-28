package com.alex.andreiev.pq;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = MaxPQ.class.getResourceAsStream("/tinyBatch.txt");
        int M = 10;
        var queue = new UnorderedMaxPQ<Transaction>(20); // Transaction data type is Comparable (ordered by $$)
//        MaxPQ queue = new MaxPQ<Transaction>(20); // Transaction data type is Comparable (ordered by $$)
        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Transaction item = new Transaction(line);
            queue.insert(item);
            if (queue.size() > M) // queue contains largest M items
                queue.delete();
        }
        while (queue.size() > 0)
            System.out.println(queue.delete().toString());

    }
}
