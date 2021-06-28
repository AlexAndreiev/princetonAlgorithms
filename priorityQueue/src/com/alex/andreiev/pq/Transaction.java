package com.alex.andreiev.pq;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction implements Comparable<Transaction>{

    private String name;
    private LocalDate date;
    private double amount;

    public Transaction(String transactionString){
        if (transactionString == null || transactionString == "")
            throw new IllegalArgumentException("transactionString is null or empty");

        parseString(transactionString);

    }

    private void parseString(String s) {
        var tokens = s.split("\\s+");
        if (tokens.length < 3) throw new IllegalArgumentException("Incorrect input string format");

        name = tokens[0];
        date = LocalDate.parse(tokens[1], DateTimeFormatter.ofPattern("M/dd/yyyy"));
        amount = Double.parseDouble(tokens[2]);
    }

    @Override
    public int compareTo(Transaction transaction) {
        return (int) (this.amount - transaction.amount);
    }

    @Override
    public String toString() {
        return String.join("\t", name, date.toString(), Double.toString(amount));
    }
}
