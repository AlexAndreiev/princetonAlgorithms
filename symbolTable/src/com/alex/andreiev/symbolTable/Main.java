package com.alex.andreiev.symbolTable;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = SymbolTable.class.getResourceAsStream("/test.txt");
        var st = new SymbolTable<String, Integer>();
        Scanner scanner = new Scanner(is);
        for (int i = 0; scanner.hasNextLine(); i++) {
            String key = scanner.nextLine();
            st.put(key, i);
        }
        for (String s: st.keys())
            System.out.println(s + " " + st.get(s));
    }
}
