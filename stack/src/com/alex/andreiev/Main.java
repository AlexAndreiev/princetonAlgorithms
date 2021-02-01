package com.alex.andreiev;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        Scanner scanner = null;
        try {
            scanner = new Scanner(Path.of("./resources/stackData.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Stack stack = new StackOfStringsLinkedList();
//        Stack stack = new StackOfStringsArrayImpl(10);
        Stack stack = new ResizedStackOfStringsArrayImpl();
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("-")) {
                try {
                    System.out.println(stack.pop());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
                stack.push(s);
        }
    }
}
