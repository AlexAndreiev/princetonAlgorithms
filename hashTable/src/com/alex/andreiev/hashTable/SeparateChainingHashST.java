package com.alex.andreiev.hashTable;

import com.alex.andreiev.utils.Node;
import com.alex.andreiev.utils.OneLinkedNode;

/*
* Separate chaining symbol table
* Use an array of M<N linked lists. (H. P. Luhn, IBM 1953)
*    - hash: map key to integer i between 0 and M-1
*    - insert: put at front of ith chain (if not already there)
*    - search: need to search only ith chain.
*
* Proposition. Under uniform hashing assumption, prob. that the number of keys in a list is
* within a constant factor of N/M is extremely close to 1
* Pf sketch. Distribution of list size obeys a binomial distribution.
*
* Consequence. Number of probes (equals() and hashCode()) for search/insert is proportional to N/M (M times faster than sequential search):
*   - M too large -> too many empty chains
*   - M too small -> chains too long
*   Typical choice: M ~ N/5 -> constant-time ops
*
* Search(worst)   Insert(worst)     delete(worst)   search(avg)     insert(avg)     delete(avg)    ordered iteration?   Key interface
*      lg N$          lg N$            lg N$           3-5$            3-5$            3-5$               no              equals()
*
*   $ - under uniform hashing assumption
* */
public class SeparateChainingHashST<Key, Value> {
    //array doubling and halving code omitted
    private int M = 97; // number of chains
    private Node[] st = new Node[M]; // array of chains

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        int i = hash(key);
        for (var x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) return (Value) x.val;
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = hash(key);
        for (var x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = value;
                return;
            }

        }
        st[i] = new Node(key, value, st[i]);
    }
}
