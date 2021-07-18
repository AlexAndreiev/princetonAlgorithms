package com.alex.andreiev.utils;

public class Node{

    public Object key;
    public Object val;
    public Node next;

    public Node(Object key, Object val){
        this.key = key;
        this.val = val;
    }

    public Node(Object key, Object val, Node next){
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
