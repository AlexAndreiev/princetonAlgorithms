package com.alex.andreiev.hashTable;

/* Open addressing. [Amdahl-Boehme-Rocherster-Samuel, IBM 1953]
* When a new key collides, find next empty slot, and put it there
*
* Heap. Map key to integer i between 0 and M-1
* Insert. Put at table index i if free; if not try i+1, i+2, etc
* Search. Search table index i; if occupied but no match, try i+1, i+2, etc
*
* Note. Array size M must be greater than number of key-value pairs N
*
* Cluster. A contiguous block of items.
* Observation. New keys likely to hash into middle of big clusters
*
* Knuth's parking problem:
* Model. Cars arrive at one-way street with M parking spaces
* Each desires a random space i: if space i is taken, try i+1, i+2, etc.
* Q. What is mean displacement of a car?
* Half-full. With M/2 cars, mean displacement is ~3/2
* Full. With M cars, mean displacement os ~sqrt(PI*M/8)
*
* Proposition. Under uniform hashing assumption, the average # of probes in a linear probing hash table of size M
* that contains N = aM keys is:
* search hit: ~1/2*(1+(1/1-a))       search miss/insert: ~1/2(1+(1/(1-a)^2))
*
* Parameters:
*   - M too large -> too many empty array entries
*   - M too small -> search time blows up
*   - Typical choice: a = N/M ~ 1.2 -> # probes for search hit is about 3/2, # probes for search miss is about 5/2
*
* * Search(worst)   Insert(worst)     delete(worst)   search(avg)     insert(avg)     delete(avg)    ordered iteration?   Key interface
 *      lg N$          lg N$            lg N$           3-5$            3-5$            3-5$               no              equals()
 *
 *   $ - under uniform hashing assumption
* */

public class LinearProbingHashST<Key, Value> {
    // array doubling and halving code omitted
    private int M = 30001;
    private Value[] vals = (Value[]) new Object[M];
    private Key[] keys = (Key[]) new Object[M];

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key))
                break;
        }
        keys[i] = key;
        vals[i] = value;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i+1) % M) {
            if (key.equals(keys[i]))
                return vals[i];
        }
        return null;
    }
}
