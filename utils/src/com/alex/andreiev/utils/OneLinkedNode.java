package com.alex.andreiev.utils;

public class OneLinkedNode <Key, Value>{

    public  Key key;
    public Value val;
    public OneLinkedNode<Key, Value> next;

    public OneLinkedNode(Key key, Value val){
        this.key = key;
        this.val = val;
    }
}
