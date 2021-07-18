package com.alex.andreiev.utils;

public class BinaryIntervalNode<Key extends Comparable<Key>, Value extends Interval> {
    public  Key key;
    public Value val;
    public BinaryIntervalNode<Key, Value> left, right;
    // max endpoint in subtrees
    public double max;

    public BinaryIntervalNode(Key key, Value val){
        this.key = key;
        this.val = val;
        max = 0;
    }

}
