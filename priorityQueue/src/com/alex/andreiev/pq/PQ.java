package com.alex.andreiev.pq;

//priority queue
public interface PQ<Key extends Comparable<Key>> {
    void insert(Key x);
    Key get();
    Key delete();
    boolean isEmpty();
    int size();

}
