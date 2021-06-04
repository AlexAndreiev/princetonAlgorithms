package com.alex.andreiev.symbolTable;

import java.io.InputStream;
import java.util.Scanner;

public class FrequencyCounter {

    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);
        InputStream is = SymbolTable.class.getResourceAsStream("/test.txt");
        Scanner scanner = new Scanner(is);
        var st = new SymbolTable<String, Integer>();

        while (scanner.hasNextLine()){
            String word = scanner.nextLine();
            if (word.length() < minLen) continue;
            if (!st.contains(word))
                st.put(word, 1);
            else
                st.put(word, st.get(word) + 1);
        }
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()){
            if (st.get(word) > st.get(max))
                max = word;
        }
        System.out.println(max + " " + st.get(max));
    }
}
