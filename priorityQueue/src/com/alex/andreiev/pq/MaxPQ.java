package com.alex.andreiev.pq;

import com.alex.andreiev.utils.Utils;

public class MaxPQ<Key extends Comparable<Key>> implements PQ<Key>{

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public MaxPQ(Key[] arr){

    }

    public void insert(Key x){
        pq[++N] = x;
        com.alex.andreiev.pq.Utils.swim(pq, N);
    }

    public Key delete(){
        Key max = pq[1];
        Utils.exchange(pq, 1, N--);
        com.alex.andreiev.pq.Utils.sink(pq,1, N);
        pq[N+1] = null; // prevent loitering
        return max;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public Key get(){
        return pq[1];
    }

    public int size(){
        return N;
    }
}
