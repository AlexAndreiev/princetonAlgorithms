package com.alex.andreiev.symbolTable;

import com.alex.andreiev.utils.BinaryComparableNode;

import java.util.Scanner;

/* Read a sequence of strings from standard input and print out one that occurs with highest frequency
* arguments:
*   - minLen string for tracking
* */

public class FrequencyCounter {

    public static void main(String[] args) {
        int minLen = 5;
        if (args.length != 0)
            minLen = Integer.parseInt(args[0]);
        var is = BSSymbolTable.class.getResourceAsStream("/tinyTale.txt");
        var scanner = new Scanner(is);
        var st = new SequentialSymbolTable<String, Integer>();
        var binaryST = new BSSymbolTable<String, Integer>();

        while (scanner.hasNextLine()){
            var word = scanner.next();
            if (word.length() < minLen) continue;
            if (!st.contains(word)) {
                st.put(word, 1);
                binaryST.put(word, 1);
            }
            else {
                st.put(word, st.get(word) + 1);
                binaryST.put(word, binaryST.get(word) + 1);
            }
        }
        var max = "";
        System.out.println("----Sequential Symbol Table----");
        st.put(max, 0);
        for (var word : st.keys()){
            if (st.get(word) > st.get(max))
                max = word;
        }
        System.out.println(max + " " + st.get(max));

        System.out.println("----Binary Search Symbol Table----");
        max = "";
        binaryST.put(max, 0);
        for (var word : binaryST.keys()){
            if (binaryST.get(word) > binaryST.get(max))
                max = word;
        }
        System.out.println(max + " " + binaryST.get(max));
    }
}
