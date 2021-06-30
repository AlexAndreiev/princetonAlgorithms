package com.alex.andreiev.symbolTable;

import com.alex.andreiev.queue.Queue;
import com.alex.andreiev.queue.QueueArrayImpl;

import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.Iterator;

public class BinarySymbolTable<Key extends Comparable<Key>, Value> implements ISymbolTable<Key, Value> {

    private Node<Key, Value> root;

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node<Key, Value> put(Node<Key, Value> x, Key key, Value value){
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);
        else if (cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.val = value;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public Value get(Key key) {
        var x = root;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.right;
            else if (cmp > 0) x = x.left;
            else return x.val;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    // Hibbard deletion
    // Unsatisfactory solution. Not symmetric
    // Surprising consequence. Trees not random (!) - sqrt(N) per op.
    // Longstanding open problem. Simple and efficient delete for BSTs
    private Node<Key, Value> delete( Node<Key, Value> x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x, key);   // search for key
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left; // no right child
            if (x.left == null) return x.right; // no left child

            // replace with successor
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) + 1; // updates subtree counts
        return x;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Node<Key, Value> x) {
        return (x == null) ? 0 : x.count;
    }

    @Override
    public Iterable<Key> keys() {
        var q = new QueueArrayImpl<Key>();
        try {
            inorder(root, q);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return q;
    }
    
    private void inorder(Node<Key, Value> x, Queue q) throws Exception {
        if (x == null) return;
        inorder(x.left, q);
        q.enqueue(x.key);
        inorder(x.right, q);
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node<Key, Value> x){
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node<Key, Value> deleteMin(Node<Key, Value> x){
        if (x.left == null) return x;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public Key floor(Key key) {
        var x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node<Key, Value> floor(Node<Key, Value> x, Key key)
    {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);

        var t = floor(x.right, key);
        if (t != null)  return t;
        else return x;
    }
}
