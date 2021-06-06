package com.alex.andreiev.twoStackAlg;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputStream is = DijkTwoStepAlg.class.getResourceAsStream("/dijk_two_stack_alg.txt");
        Scanner scanner = new Scanner(Objects.requireNonNull(is));
        while (scanner.hasNext()){
            String res = null;
            try {
                res = String.valueOf(DijkTwoStepAlg.calcExpression(scanner.nextLine()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(res);
        }
    }
}
