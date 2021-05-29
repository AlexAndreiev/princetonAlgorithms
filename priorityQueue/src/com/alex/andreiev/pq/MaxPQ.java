package com.alex.andreiev.pq;

import com.alex.andreiev.utils.Utils;

public class MaxPQ <Key extends Comparable<Key> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int capacity){
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public MaxPQ(Key[] arr){

    }

    public void insert(Key x){
        pq[++N] = x;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];
        Utils.exchange(pq, 1, N--);
        sink(1);
        pq[N+1] = null; // prevent loitering
        return max;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public Key max(){
        return pq[1];
    }

    public int size(){
        return N;
    }

    private void swim(int k){
        while (k > 1 && Utils.less(pq[k/2], pq[k])){
            Utils.exchange(pq, k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k <= N)
        {
            int j = 2*k;
            if (j<N && Utils.less(pq[j], pq[j+1]))
                j++;
            if (!Utils.less(pq[k], pq[j])) break;
            Utils.exchange(pq, k, j);
            k = j;
        }
    }
}
