package com.alex.andreiev.hashTable;

/*
* Basic plan
* Save items in a key-indexed table (index is a function of the key)
* Hash function. Method for computing array index from key
*
* Issues.
*   - computing the hash function
*   - equality test: Method for checking whether two keys are equal
*   - collision resolution: algorithm and data structure to handle two keys that hash to the same array index
*
* Classic space-time tradeoff:
*   - no space limitation: trivial hash function with key as index
*   - no time limitation: trivial collision resolution with sequential search
*   - space and time limitations: hashing (the real world)
*
* Computing the hash function:
* Idealistic goal. Scramble the keys uniformly to produce a table index
*   - efficiently computable
*   - each table index equally likely for each key (thoroughly researched problem, still problematic in practical applications)
* Practical challenge. Need different approach for each key type
*
* Performance optimization (for immutable types):
*   - cache the hash value in an instance variable
*   - return cached value
*
* Hash code design.
* "Standard" recipe for user-defined types.
*   - combine each significant field using the 31x+y rule
*   - if field is a primitive type, use wrapper type hashCode().
*   - if field is null return 0;
*   - if field is a reference type, use hashCode (applies rule recursively)
*   - if field is an array, apply to each entry (or use Arrays.deepHashCode())
* In practice. Recipe works reasonably well; used in Java libraries
* In theory. Keys are bitstring; "universal" hash functions exist.
*
* Basic rule: need to use the whole key to compute hash code; consult an expert for state-of-the-art hash codes.
*
* Modular hashing
* Hash code. An int between -2^31 and 2^31-1
* Hash function. An int between 0 and M-1 (M is typically a prime or power of 2) (for use as array index)
* BUG
* private int hash(Key key)
* { return key.hashCode() % M; }
*
* 1 IN-A-BILLION BUG - hashCode() of "polygenelubricants" is -2^31
* private int hash(Key key)
* { return Math.abs(key.hashCode()) % M; }
*
* CORRECT
* private int hash(Key key)
* { return key.hashCode() & 0x7fffffff % M; }
*
*
* Uniform hashing assumption. Each key is equally likely to hash to an integer between 0 and M-1
* Bins and balls. Throw balls uniformly at random into M bins
* Birthday problem. Expect two balls in the same bin after ~sqrt(PI*M/2) tosses
* Coupon collector. Expect every bin has >= 1 ball after ~ M ln M tosses
* Load balancing. After M tosses, expect most loaded bin has Theta(log M / log log M) balls
* */

/* Collisions. Two distinct keys hashing to same index:
*   - birthday problem -> can't avoid collisions unless you have a ridiculous (quadratic) amount of memory
*   - coupon collector + load balancing -> collisions will be evenly distributed
* Challenge. Deal with collisions efficiently
*
*
* One-way hash function. "Hard" to find a key that will hash to a desired value (or two keys that hash to same value)
* Application. Digital fingerprint, message digest, storing password.
* Caveat. Too expensive for use in ST implementations
*
* Two-probe hashing. (separate-chaining variant)
*   - hash to two positions, insert key in shorter of the two chains.
*   - reduces expected length of the longest chain to log log N
*
* Double hashing (linear-probing variant)
*   - use linear probing, but skip a variable amount, not just 1 each time
*   - effectively eliminates clustering
*   - can allow table to become nearly full
*   - More difficult to implement delete
*
* Cuckoo hashing (linear-probing variant)
*   - hash key to two positions; insert key into either position; if occupied, reinsert displaced key into
*       its alternative position (and recur).
*   - constant worst case time for search
*
* Hash tables vs balanced search trees:
* Hash tables:
*   - simpler to code
*   - no effective alternative for unordered keys
*   - faster for simple keys (a few arithmetic pos versus log N compares)
*   - better system support in Java for strings (e. g., cached hash code)
*
* Balanced search tree:
*   - stronger performance guarantee
*   - support for ordered ST operations
*   - easier to implement compareTo() correctly than equals() and hashCode()
* */

public class HashTable {
}
