package com.alex.andreiev.pq;

public abstract class BasePQ<Key extends Comparable<Key>> implements PQ<Key>{

    protected Key[] pq;
    protected int N = 0;

    public BasePQ(int capacity){
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }
}
