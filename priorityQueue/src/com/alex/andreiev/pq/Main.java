package com.alex.andreiev.pq;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = MaxPQ.class.getResourceAsStream("/tinyBatch.txt");
        MaxPQ queue = new MaxPQ<Transaction>(); // Transaction data type is Comparable (ordered by $$)
        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Transaction item = new Transaction(line);
            queue.insert(item);
            if (queue.size() > M) // queue contains largest M items
                queue.delMin();
        }
    }
}
