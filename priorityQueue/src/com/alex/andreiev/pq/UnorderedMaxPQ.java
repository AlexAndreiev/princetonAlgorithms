package com.alex.andreiev.pq;

import com.alex.andreiev.utils.Utils;

public class UnorderedMaxPQ <Key extends Comparable<Key>> implements PQ<Key>{

    private Key[] pq; //pq[i] = ith element on pq
    private int N;  // number of elements

    public UnorderedMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity]; // no generic array creation
    }

    @Override
    public void insert(Key x) {
        pq[N++] = x;
    }

    @Override
    public Key delete() {
        int max = getMaxIndex();
        Utils.exchange(pq, max, N-1);
        return pq[--N];     // null out entry to prevent loitering
    }

    @Override
    public Key get() {
        return pq[N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Key max() {
        int max = getMaxIndex();
        return pq[max];
    }

    public int size() {
        return N;
    }

    private int getMaxIndex() {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (Utils.less(pq[max], pq[i]))
                max = i;
        }
        return max;
    }
}
