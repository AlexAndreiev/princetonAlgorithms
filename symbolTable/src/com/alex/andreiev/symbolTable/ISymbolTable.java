package com.alex.andreiev.symbolTable;

public interface ISymbolTable<Key extends Comparable<Key>, Value> {

    void put(Key key, Value val);
    Value get(Key key);
    void delete(Key key);
    boolean isEmpty();
    int size();
    Iterable<Key> keys();
    boolean contains(Key key);

    //comparable extended ordered operations
//    Key min();
//    Key max();
    Key floor(Key key); // largest key less than or equal to key
    Key ceiling(Key key);   // smallest key greater than or equal to key
    int rank(Key key);  // number of keys less than key
    Key select(int k);  // key of rank k
    void deleteMin();
//    void deleteMax();
//    int size(Key lo, Key hi);
//    Iterable<Key> keys(Key lo, Key hi); // key in [lo..hi], in sorted order
}
