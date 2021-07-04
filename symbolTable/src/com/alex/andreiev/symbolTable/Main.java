package com.alex.andreiev.symbolTable;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

//    Build ST associating value i with ith string from standard input
    public static void main(String[] args) {
        InputStream is = BSSymbolTable.class.getResourceAsStream("/test.txt");
        var st = new SequentialSymbolTable<String, Integer>();
        var binaryST = new BSSymbolTable<String, Integer>();
        Scanner scanner = new Scanner(is);
        for (int i = 0; scanner.hasNextLine(); i++) {
            String key = scanner.nextLine();
            st.put(key, i);
            binaryST.put(key, i);
        }

        System.out.println("----Sequential Symbol Table----");
        for (String s: st.keys())
            System.out.println(s + " " + st.get(s));

        System.out.println("----Binary Search Symbol Table----");
        for (String s: binaryST.keys())
            System.out.println(s + " " + binaryST.get(s));

        System.out.println("Binary Search ST - floor " + binaryST.floor("D"));
        System.out.println("Binary Search ST - ceiling " + binaryST.ceiling("D"));
        System.out.println("Binary Search ST - select " + binaryST.select(3));
    }
}
