package com.alex.andreiev.balancedSearchTree.geomApplications;

public interface IIntervalST <Key extends Comparable<Key>, Value> {

    // put interval-value pair into ST
    void put(Key lo, Key hi, Value value);

    //value paired with given interval
    Value get(Key lo, Key hi);

    //delete the given interval
    void delete(Key lo, Key hi);

    //all intervals that intersect the given interval
    Iterable<Value> intersects(Key lo, Key hi);
}
