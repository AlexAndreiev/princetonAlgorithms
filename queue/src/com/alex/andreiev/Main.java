package com.alex.andreiev;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(Path.of("./resources/queueData.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        QueueOfStrings queue = new QueueLinkedList();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("-")) {
                try {
                    System.out.println(queue.dequeue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
                queue.enqueue(s);
        }
    }
}
