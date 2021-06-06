package com.alex.andreiev.stack;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        InputStream is = Stack.class.getResourceAsStream("/stackData.txt");

        Scanner scanner = new Scanner(Objects.requireNonNull(is));

        var stack = new StackLinkedList<String>();
//        Stack stack = new StackOfStringsArrayImpl<String>(10);
//       Stack stack = new ResizedStackArrayImpl<String>();
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
        System.out.println("--------------------------");
        stack = new StackLinkedList<>();
        is = Stack.class.getResourceAsStream("/iterableTest.txt");
        scanner = new Scanner(Objects.requireNonNull(is));
        while (scanner.hasNext())
            stack.push(scanner.next());
        for (var s: stack)
            System.out.println(s);
    }
}
