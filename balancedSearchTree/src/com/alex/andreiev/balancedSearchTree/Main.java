package com.alex.andreiev.balancedSearchTree;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = TwoThreeTree.class.getResourceAsStream("/test.txt");
        Scanner scanner = new Scanner(is);
    }
}
