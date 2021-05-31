package com.alex.andreiev.pq;

public class BasePQ<Key extends Comparable<Key>> implements PQ<Key>{

    protected Key[] pq;
    protected int N = 0;

    public BasePQ(int capacity){
        pq = (Key[]) new Comparable[capacity + 1];
    }


    public int size(){
        return N;
    }

    @Override
    public void insert(Key x) {

    }

    @Override
    public Key get() {
        return null;
    }

    @Override
    public Key delete() {
        return null;
    }

    public boolean isEmpty(){
        return N == 0;
    }
}
