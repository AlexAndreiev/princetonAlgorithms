package com.alex.andreiev.symbolTable;

//comparable extended ordered operations
public interface IOrderedST<Key extends Comparable<Key>, Value> extends IUnorderedST<Key, Value> {

    Key min();
    Key max();
    Key floor(Key key); // largest key less than or equal to key
    Key ceiling(Key key);   // smallest key greater than or equal to key
    int rank(Key key);  // number of keys less than key
    Key select(int k);  // key of rank k
    void deleteMin();
    void deleteMax();
    int size(Key lo, Key hi); // number of keys in [lo..hi]
    Iterable<Key> keys(Key lo, Key hi); // key in [lo..hi], in sorted order
}
