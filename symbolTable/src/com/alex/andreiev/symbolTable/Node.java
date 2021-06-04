package com.alex.andreiev.symbolTable;

public class Node<Key extends Comparable<Key>, Value> {

    public  Key key;
    public Value val;
    public Node<Key, Value> left, right;
    public int count;

    public Node(Key key, Value val){
        this.key = key;
        this.val = val;
    }

}
