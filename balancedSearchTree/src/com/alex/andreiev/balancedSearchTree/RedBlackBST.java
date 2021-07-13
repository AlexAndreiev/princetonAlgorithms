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
* Proposition. Height if tree is <= 2 lg N in the worst case
* Proof.
*   - Every path from root to null link has same number of black links
*   - Never two red links in-a-row
* Property. Height of tree is ~ 1.00 lg N in typical applications.
*
*  Search(worst)   Insert(worst)   Delete(worst)   Search hit(avg)     insert(avg)     Delete(avg)     ordered iteration?   Key interface
*      2 lgN          2 lg N           2 lgN        1.00 lgN (#)       1.00 lgN (#)    1.00 lgN (#)            yes           CompareTo()
*
* # - exact value of coefficient unknown but extremely close to 1
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

    /* Basic strategy.
    * Maintain 1-1 correspondence with 2-3 trees by applying elementary red-black BST operations
    * Warmup 1. Insert into a tree with exactly 1 node
    *   Case 1. Insert into a 2-node at the bottom
    *       - Do standard BST insert; color new link red
    *       - If new red link is a right link, rotate left
    * Warmup 2. Insert into a tree with exactly 2 nodes
    *   Case 2. Insert into a 3-node at hte bottom
    *       - Do standard BST insert; color new link red
    *       - Rotate to balance the 4-node (if needed)
    *       - Flip colors to pass red link up one level
    *       - Rotate to male lean left (if needed)
    *       - Repeat case 1 or case 2 up the tree (if needed)
    *   Case 2.1. Larger than key
    *       - search ends at this null link
    *       - attached new node with red link
    *       - colors flipped to black
    *   Case 2.2. Smaller than key
    *       - search ends at this null link
    *       - attached new node with red link
    *       - rotated right
    *       - colors flipped to black
    *   Case 2.3. Between keys
    *       - search ends at this null link
    *       - attached new node with red link
    *       - rotated right
    *       - colors flopped to black
    *
    *  Same code handles all cases.
    *   - Right child red, left child black: rotate left
    *   - Left child, left-left grandchild red: rotate right
    *   - Both children red: flip colors
    * */
    @Override
    public void put(Key key, Value val) {
        put(root, key, val);
    }

    private RedBlackNode<Key, Value> put(RedBlackNode<Key, Value> h, Key key, Value val)
    {
        if (h == null) return new RedBlackNode<>(key, val, RedBlackColor.RED); // insert at bottom (and color red)
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;   // cmp == 0

        // only a few extra lines of code provides near-perfect balance
        if (isRed(h.right) && !isRed(h.left))       h = rotateLeft(h);  // lean left
        if (isRed(h.left) && isRed(h.left.left))    h = rotateRight(h); // balance 4-node
        if (isRed(h.left) && isRed(h.right))        flipColors(h);  // split 4-node

        return h;
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


    // Color flip. Recolor to split a (temporary) 4 node.
    // Invariants. Maintains symmetric order and perfect lack balance
    private void flipColors(RedBlackNode h) {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RedBlackColor.RED;
        h.left.color = RedBlackColor.BLACK;
        h.right.color = RedBlackColor.BLACK;
    }


    private boolean isRed(RedBlackNode x) {
        if (x == null) return false; // null links are black
        return x.color == RedBlackColor.RED;
    }
}
