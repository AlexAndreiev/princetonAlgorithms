package com.alex.andreiev.twoStackAlg;

import com.alex.andreiev.stack.ResizedStackArrayImpl;
import com.alex.andreiev.stack.Stack;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;

public class  DijkTwoStepAlg {
    private static final List operators = Arrays.asList("+", "-", "/", "*") ;

    public static double calcExpression(String expression) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(expression, " \\+-*/()", true);
        Stack<Double> valueStack = new ResizedStackArrayImpl();
        Stack<String> operatorStack = new ResizedStackArrayImpl();

        while (tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            if (isNumber(token)){
                valueStack.push(Double.parseDouble(token));
            }
            else if (isOperator(token)) {
                operatorStack.push(token);
            }
            else if (token.equals(")")) {
                double val1 = valueStack.pop();
                double val2 = valueStack.pop();
                String op = operatorStack.pop();
                valueStack.push(doOperation(val1, val2, op));
            }
        }
        return valueStack.pop();
    }

    private static boolean isNumber(String str){
        try {
            Double.parseDouble(str);
            return  true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String str){
        return (operators.contains(str));
    }

    private static double doOperation(double val1, double val2, String op) throws Exception {
        switch (op){
            case "+":   return val1 + val2;
            case "-":   return val1 - val2;
            case "/":   return val1 / val2;
            case "*":   return val1 * val2;
            default:    throw new Exception("Incorrect operator provided.");
        }
    }
}

