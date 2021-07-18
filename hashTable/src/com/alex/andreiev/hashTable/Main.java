package com.alex.andreiev.hashTable;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = HashTable.class.getResourceAsStream("/test.txt");
        Scanner scanner = new Scanner(is);
    }
}
