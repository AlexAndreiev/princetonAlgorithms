package com.alex.andreiev.queue;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        InputStream is = QueueLinkedList.class.getResourceAsStream("/queueData.txt");
        Scanner scanner = new Scanner(Objects.requireNonNull(is));

//        var queue = new QueueLinkedList<String>();
        var queue = new QueueArrayImpl<String>();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("-")) {
                try {
                    System.out.println(queue.dequeue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    queue.enqueue(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Size = " + queue.getSize());


        System.out.println("--------------------------");
//        queue = new QueueLinkedList<String>();
        queue = new QueueArrayImpl<>();
        is = Queue.class.getResourceAsStream("/iterableTest.txt");
        scanner = new Scanner(Objects.requireNonNull(is));
        while (scanner.hasNext())
            queue.enqueue(scanner.next());
        for (var s: queue)
            System.out.println(s);
    }
}
