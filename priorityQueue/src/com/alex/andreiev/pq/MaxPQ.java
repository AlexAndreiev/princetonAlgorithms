package com.alex.andreiev.pq;

import static com.alex.andreiev.utils.Utils.*;

public class MaxPQ<Key extends Comparable<Key>> extends BasePQ<Key>{

    public MaxPQ(int capacity) {
        super(capacity);
    }

    /* Add node at end, then swim it up
    * At most 1+lgN compares
    * */
    public void insert(Key x){
        pq[++N] = x;
        swim(pq, N);
    }

    /* Exchange root with node at end, then sink it down
    * At most 2lgN compares
    * */
    public Key delete(){
        Key max = pq[1];
        exchange(pq, 1, N--);
        sink(pq,1, N);
        pq[N+1] = null; // prevent loitering
        return max;
    }

    public Key get(){
        return pq[1];
    }
}
