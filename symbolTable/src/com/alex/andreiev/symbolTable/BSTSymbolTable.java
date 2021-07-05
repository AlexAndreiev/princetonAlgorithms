package com.alex.andreiev.symbolTable;

import com.alex.andreiev.queue.Queue;
import com.alex.andreiev.queue.QueueArrayImpl;
import com.alex.andreiev.utils.BinaryComparableNode;

/* BST - Binary Search Tree
* Proposition. If N distinct keys are inserted into a BST in random order,
* the expected number of compares for a search/insert is ~2 ln N.
* If N distinct keys are inserted in random order, expected height if tree is ~4,311 ln N
* But... Worst-case height is N (exponentially small chance when keys are inserted in random order)
*
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

public class BSTSymbolTable<Key extends Comparable<Key>, Value> implements IOrderedST<Key, Value> {

    private BinaryComparableNode<Key, Value> root;

    /* if less, go left; if greater, fo right; if null, insert
    * Cost. Number of compares is equal to 1+ depth of node
     */
    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private BinaryComparableNode<Key, Value> put(BinaryComparableNode<Key, Value> x, Key key, Value value){
        if (x == null) return new BinaryComparableNode(key, value);
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

    /*Search. If less, go left; if greater, go right; if equal, search hit
    * Cost. Number of compares is equal to 1+ depth of node
    * */
    @Override
    public Value get(Key key) {
        var x = root;
        while (x != null){
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    /* Hibbard deletion - to delete a node with key k: search for note t containing key k
    * Case 0. [0 children] Delete t by setting parent link to null
    * Case 1. [1 child] Delete t by replacing parent link.
    * Case 2. [2 children]
    *   Find successor x of t.  (x has no left child))
    *   Delete the minimum in t's right subtree     (but don't garbage collect x)
    *   Put x in t's spot       (still a BST)
    */

/*
     Unsatisfactory solution. Not symmetric
     Surprising consequence. Trees not random (!) - sqrt(N) per op.
     Longstanding open problem. Simple and efficient delete for BSTs
*/
    private BinaryComparableNode<Key, Value> delete(BinaryComparableNode<Key, Value> x, Key key){
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x, key);   // search for key
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left; // no right child
            if (x.left == null) return x.right; // no left child

            // replace with successor
            BinaryComparableNode t = x;
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

    public int size(BinaryComparableNode<Key, Value> x) {
        return (x == null) ? 0 : x.count;
    }

    /* Traverse left subtree
    * Enqueue key
    * Traverse right subtree
    * */
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

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    // inorder traversal of a BST yields keys in ascending order
    private void inorder(BinaryComparableNode<Key, Value> x, Queue q) throws Exception {
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

    private int rank(Key key, BinaryComparableNode<Key, Value> x){
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

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    private BinaryComparableNode<Key, Value> deleteMin(BinaryComparableNode<Key, Value> x){
        if (x.left == null) return x;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }


    @Override
    public Key min() {
        return null;
    }

    private BinaryComparableNode min(BinaryComparableNode parentNode) {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    /* Case 1. [k equals the key at root]
    *   The floor of k is k
    * Case 2. [k is less than the key at root]
    *   The floor of k is in the left subtree
    * Case 3. [k is greater than the key at root]
    *   The floor of k is in the right subtree (if there is any key <= k in right subtree);
    *   otherwise it is the key in the root
    * */
    @Override
    public Key floor(Key key) {
        var x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private BinaryComparableNode<Key, Value> floor(BinaryComparableNode<Key, Value> x, Key key)
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
