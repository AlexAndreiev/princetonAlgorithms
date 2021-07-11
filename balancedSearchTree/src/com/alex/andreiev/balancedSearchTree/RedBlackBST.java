package com.alex.andreiev.balancedSearchTree;

/* Left-leaning red-black BSTs (Guibas-Sedgewick 1979 and Sedgewick 2007) (LLRB)
* Represent 2-3 tree as a BST (binary search tree)
* Use "internal" left-learning links as "glue" for 3-nodes.
*
* An equivalent definition:
* A BST such that:
*   - no node has two red links connected to it
*   - every path from root to null link has the same number of black links (perfect black balance)
*   - Red links lean left
*
* Key property. 1-1 correspondence between 2-3 and LLRB. Easy to see that with horizontal red links
*
* Observation. Search is the same as for elementary BST (ignore color) -> but runs faster because of better balance
* Most other ops (e. g., ceiling, selection) are also identical
*
* Representation.
* Each node is pointed to by precisely one link (from its parent) -> can encode color of links in nodes
*
*
* */

import com.alex.andreiev.symbolTable.IOrderedST;
import com.alex.andreiev.utils.RedBlackColor;
import com.alex.andreiev.utils.RedBlackNode;

public class RedBlackBST<Key extends Comparable<Key>, Value> implements IOrderedST<Key, Value> {

    private RedBlackNode<Key, Value> root;

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

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public void put(Key key, Value val) {

    }

    @Override
    public Value get(Key key) {
        var x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.val;
            if (cmp > 0) return get(x.right.key);
            else return get(x.left.key);

        }
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
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    // Left rotation. Orient a (temporarily) right-leaning red link to lean left
    // Invariants. Maintains symmetric order and perfect lack balance
    private RedBlackNode rotateLeft(RedBlackNode h) {
        assert isRed(h.right);
        var x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RedBlackColor.RED;
        return x;
    }

    // Right rotation. Orient a left-leaning red link to lean right
    // Invariants. Maintains symmetric order and perfect lack balance
    private RedBlackNode rotateRight(RedBlackNode h) {
        assert isRed(h.left);
        var x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RedBlackColor.RED;
        return x;
    }


    private boolean isRed(RedBlackNode x) {
        if (x == null) return false; // null links are black
        return x.color == RedBlackColor.RED;
    }
}
