package com.alex.andreiev.pq;

/* Priority queue
* Applications:
*   - Event-driven simulation - customers in a line, colliding particles
*   - Numerical computation - reducing roundoff error
*   - Data compression - Huffman codes
*   - Graph searching - Dijkstra's algorithm, Prism's algorithm
*   - Number theory - sum of powers
*   - Artificial intelligence - A^* search
*   - Statistics - maintain largest M values in a sequence
*   - Operating systems - load balancing, interrupt handling
*   - Discrete optimization - bin packing, scheduling
*   - Spam filtering - Bayesian spam filter
*/

public interface PQ<Key extends Comparable<Key>> {
    void insert(Key x);
    Key get();
    Key delete();
    boolean isEmpty();
    int size();


}
