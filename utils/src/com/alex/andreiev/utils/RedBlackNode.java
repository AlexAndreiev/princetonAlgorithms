package com.alex.andreiev.utils;

public class RedBlackNode<Key extends Comparable<Key>, Value>{

    public Key key;
    public Value val;
    public RedBlackNode<Key, Value> left, right;
    public RedBlackColor color; // color of parent link

    public RedBlackNode(Key key, Value val, RedBlackColor color) {
        this.key = key;
        this.val = val;
        this.color = color;
    }
}
