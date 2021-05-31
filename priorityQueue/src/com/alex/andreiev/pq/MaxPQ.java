package com.alex.andreiev.pq;

import com.alex.andreiev.utils.Utils;

public class MaxPQ<Key extends Comparable<Key>> extends BasePQ<Key>{

    public MaxPQ(int capacity) {
        super(capacity);
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

    public Key get(){
        return pq[1];
    }
}
