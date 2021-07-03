package com.alex.andreiev.utils;

public class BinaryComparableNode<Key extends Comparable<Key>, Value> {

    public  Key key;
    public Value val;
    public BinaryComparableNode<Key, Value> left, right;
    // number of nodes in the subtree rooted at that node
    //  this facilitates efficient implementation of rank() and select()
    public int count;

    public BinaryComparableNode(Key key, Value val){
        this.key = key;
        this.val = val;
    }

}
