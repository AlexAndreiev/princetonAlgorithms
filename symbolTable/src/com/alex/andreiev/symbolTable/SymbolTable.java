package com.alex.andreiev.symbolTable;

/*binary search (ordered array) - Efficient implementations of both search and insert
* Rank helper function. How many keys < k?
* Problem. To insert, need to shift greater keys over
 * Search(guarantee)   Insert(guarantee)      Search hit(qvg)     insert(avg)     ordered iteration?   Key interface
 *      log N                  N                  log N               N/2               yes               CompareTo()
*/

/* binary search tree
 * Search(guarantee)   Insert(guarantee)      Search hit(avg)     insert(avg)     ordered iteration?   Key interface
 *          h                  h                    h                  h                yes              CompareTo()
 *
 * h = height of BST (proportional to log N if keys inserted in random order)
 *
 *
 * Search(guarantee)    Insert (guarantee)  Delete(guarantee)   Search hit(avg)     Insert(avg)     Delete (avg)
 *   N                          N                  N                 1.39lgN          1.39lbN         sqrt(N)
 *  Because of allowed deletion other operations also become sqrt(N)
 */

public class SymbolTable<Key extends Comparable<Key>, Value> implements IOrderedST<Key, Value> {

    private int N = 0;
    private Comparable<Key>[] keys;
    private Value[] vals;

    @Override
    public void put(Key key, Value val) {

    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = Utils.rank(keys, key, N);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }
}
