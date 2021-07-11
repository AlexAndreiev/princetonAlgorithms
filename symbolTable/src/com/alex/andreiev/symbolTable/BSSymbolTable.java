package com.alex.andreiev.symbolTable;

import com.alex.andreiev.queue.QueueArrayImpl;

import java.util.List;
import java.util.ArrayList;

/*binary search (ordered array) - Efficient implementations of both search and insert
* Rank helper function. How many keys < k?
* Problem. To insert, need to shift greater keys over
 * Search(guarantee)   Insert(guarantee)      Search hit(qvg)     insert(avg)     ordered iteration?   Key interface
 *      log N                  N                  log N               N/2               yes               CompareTo()
*/

public class BSSymbolTable<Key extends Comparable<Key>, Value> implements IOrderedST<Key, Value> {

    private final List<Key> keys;
    private final List<Value> vals;

    public BSSymbolTable() {
        keys = new ArrayList<>();
        vals = new ArrayList<>();
    }

    @Override
    public void put(Key key, Value val) {
        var keyIndex = rank(key);
        if (isEmpty() || size() == keyIndex) { // need to add to the end
            keys.add(key);
            vals.add(val);
        }

        if (keys.get(keyIndex).compareTo(key) != 0)
        {
            keys.add(keyIndex, key);
            vals.add(keyIndex, val);
        }
        else
            vals.set(keyIndex, val);
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < keys.size() && keys.get(i).compareTo(key) == 0)
            return vals.get(i);
        else
            return null;
    }

    @Override
    public void delete(Key key) {
        if (isEmpty()) return;
        var keyIndex = rank(key);
        if (keys.get(keyIndex).compareTo(key) == 0) {
            keys.remove(keyIndex);
            vals.remove(keyIndex);
        }
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public Iterable<Key> keys() {
        return keys;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return keys.subList(rank(lo), rank(hi));
    }

    @Override
    public boolean contains(Key key) {
        if (isEmpty()) return false;
        return keys.get(rank(key)).compareTo(key) == 0;
    }

    @Override
    public Key min() {
        return keys.get(0);
    }

    @Override
    public Key max() {
        return keys.get(size()-1);
    }

    @Override
    public Key floor(Key key) {
        if (size() == 0) return null;
        var index = rank(key);

        var foundKey = keys.get(index);
        if (key.compareTo(foundKey) == 0) return foundKey;
        else if (index != 0) return keys.get(index-1);
        else return null;
    }

    @Override
    public Key ceiling(Key key) {
        if (size() == 0) return null;
        var index = rank(key);
        if (index == size()) return null;

        var foundKey = keys.get(index);
        if (key.compareTo(foundKey) <= 0) return foundKey;
        else if (index != size()-1) return keys.get(index+1);
        else return null;
    }

    @Override
    public int rank(Key key) {
        int lo = 0;
        int hi = size()-1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys.get(mid));
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else    return mid;
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        if (size() == 0) return null;
        if (k < 0 || k >= size()) return null;
        return keys.get(k);
    }

    @Override
    public void deleteMin() {
        keys.remove(0);
        vals.remove(0);
    }

    @Override
    public void deleteMax() {
        keys.remove(size());
        vals.remove(size());
    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }
}
