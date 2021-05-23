package com.alex.andreiev.pq;

import com.alex.andreiev.utils.Utils;

public class UnorderedMaxPQ <Key extends Comparable<Key>> {

    private Key[] pq; //pq[i] = ith element on pq
    private int N;  // number of elements

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity]; // no generic array creation
    }

    public void insert(Key x) {
        pq[N++] = x;
    }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++)
            if (Utils.less(max, i))
                max = i;
        Utils.exchange(max, N-1);
        return pq[--N];     // null out entry to prevent loitering
    }

    public boolean isEmpty() {
        return N == 0;
    }

//    public Key max() {
//
//    }
//
//    public int size() {
//    }
}
