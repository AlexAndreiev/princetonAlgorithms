package com.alex.andreiev.symbolTable;

/* Value type. Any generic type
*  Key type: several natural assumptions:
*   - Assume keys are Compatible, use compareTo()
*   - Assume keys are any generic type, user equals() to test equality.
*   - Assume keys are any generic type, use equals() to test equality, user hashCode() to scramble key
*
* Best practices. Use immutable types for symbol table keys
*
* Java equality requirements. For any references x, y and z:
*   - Reflexive: x.equals(x) is true.
*   - Symmetric: x.equals(y) iff y.equals(x)
*   - Transitive: if x.equals(y) and y.equals(z), them x.equals(z)
*   - Non-null: x.equals(null) is false.
* */

/* A BST is a binary tree in symmetric order
* Symmetric order. Each node has a key, and every node's key is:
*   - Larger than all keys in its left subtree
*   - Smaller than all keys in its right subtree
*
* */

public interface IUnorderedST<Key, Value> {

    void put(Key key, Value val);
    Value get(Key key);
    void delete(Key key);
    boolean isEmpty();
    int size();     // number of key-value pairs
    boolean contains(Key key);
    Iterable<Key> keys();   // all keys in the table, in sorted/unsorted order

}
