package com.alex.andreiev.symbolTable;

import com.alex.andreiev.utils.OneLinkedNode;

/*
 * sequential search. Maintain an (unordered) linked list of key-value pairs.
 * Search. Scan through all keys until find a match
 * Insert. Scan through all keys until find a match; if no match add to front.
 * Search(guarantee)   Insert(guarantee)      Search hit(avg)     insert(avg)     ordered iteration?   Key interface
 *       N                    N                      N/2               N                 no              equals()
 */
public class SequentialSymbolTable<Key, Value> implements IUnorderedST<Key, Value> {

    private OneLinkedNode<Key, Value> root;
    private int count = 0;

    @Override
    public void put(Key key, Value val) {
        var node = find(key);
        if (node != null) node.val = val;
        else {  //add new node
            node = new OneLinkedNode<Key, Value>(key, val);
            node.next = root;
            root = node;
            count++;
        }
    }

    @Override
    public Value get(Key key) {
        var node = find(key);
        return node != null ? node.val : null;
    }

    private OneLinkedNode<Key, Value> find(Key key) {
        var node = root;
        while (node != null)
        {
            if (node.key == key)
                return node;
            node = node.next;
        }
        return null;    // not found
    }

    @Override
    public void delete(Key key) {
        if (root.key == key) {
            root = null;
            count--;
            return;
        }

        var node = root;
        while (node.next != null) {
            if (node.next.key == key) {
                node.next = node.next.next;
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(Key key) {
        return find(key) != null;
    }

}
