package com.alex.andreiev.symbolTable;

import java.io.InputStream;
import java.util.Scanner;

/*Read a sequence of strings from standard input and print out one that occurs with highest frequency
* arguments:
*   - minLen string for tracking
* */

public class FrequencyCounter {

    public static void main(String[] args) {
        int minLen = Integer.parseInt(args[0]);
        var is = SymbolTable.class.getResourceAsStream("/tinyTale.txt");
        var scanner = new Scanner(is);
        var st = new SymbolTable<String, Integer>();

        while (scanner.hasNextLine()){
            var word = scanner.nextLine();
            if (word.length() < minLen) continue;
            if (!st.contains(word))
                st.put(word, 1);
            else
                st.put(word, st.get(word) + 1);
        }
        var max = "";
        st.put(max, 0);
        for (var word : st.keys()){
            if (st.get(word) > st.get(max))
                max = word;
        }
        System.out.println(max + " " + st.get(max));
    }
}
