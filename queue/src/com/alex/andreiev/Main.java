package com.alex.andreiev;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = QueueLinkedList.class.getResourceAsStream("/queueData.txt");
        Scanner scanner = new Scanner(is);

//        Queue queue = new QueueLinkedList<String>();
        Queue queue = new QueueArrayImpl<String>();
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
    }
}
