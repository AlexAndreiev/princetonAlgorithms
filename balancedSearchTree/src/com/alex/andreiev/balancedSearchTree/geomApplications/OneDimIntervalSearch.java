package com.alex.andreiev.balancedSearchTree.geomApplications;

/* 1 dimension interval search. Data structure to hold set of (overlapping) intervals
*   - insert an interval (lo, hi)
*   - search for an interval (lo, hi)
*   - delete an interval (lo, hi)
*   - interval intersection query: given an interval (lo, hi), find all intervals (or more interval) in data
*       structure that intersects (lo, hi)
*
* Nondegeneracy as assumption. No two intervals have the same left endpoint
*
* Interval search trees
* Create BST, where each node stores an interval (lo, hi)
*   - Use left endpoint as BST key
*   - Store max endpoint in subtree rooted at node
*
* Implementation. Use a red-black BST (easy to maintain auxiliary information using log N extra work per op)
*   to guarantee performance
*
* Operation                                         brute       interval search tree        best in theory
* insert interval                                     1                 log N                   log N
* find interval                                       N                 log N                   log N
* delete any one interval that intersects (lo, hi)    N                 log N                   log N
* find all intervals that intersects (lo, hi)         N                 R log N               R + log N
* */

import com.alex.andreiev.utils.BinaryIntervalNode;
import com.alex.andreiev.utils.Interval;

public class OneDimIntervalSearch implements IIntervalST<Double, Interval> {

    BinaryIntervalNode<Double, Interval> root;

/* To insert an interval (lo, hi):
*   - insert into BST, using lo as the key
*   - Update max in each node on search path
* */
    @Override
    public void put(Double lo, Double hi, Interval value) {

    }

    /* To search for any one interval that intersects query interval (lo, hi):
    *   - if interval in node intersects query interval, return it
    *   - else if left subtree is null, go right
    *   - else if max endpoint in left subtree is less that lo, go right
    *   - else go left
    * */
    /* Case 1. if search goes right, then no intersection in left.
    * Pf.
    *   - left subtree is empty -> trivial
    *   - max endpoint max in left subtree is less then lo -> for any interval (a, b) in left subtree of x,
    *       we have b (definition of max) <= max (reason for going right) < lo
    *
    * Case 2. If search goes left, then there is either an intersection in left subtree or no intersections in either.
    * Pf. Suppose no intersection in left
    *   - since went left, we have lo <= max
    *   - then for any interval (a, b) in right subtree of x,
    *       hi (no intersections in left subtree) <= c (intervals sorted by left endpoint) <= a -> no intersection in right
    * */
    @Override
    public Interval get(Double lo, Double hi) {
        var x = root;
        while (x != null) {
            if      (x.val.intersects(lo, hi))  return x.val;
            else if (x.left == null)            x = x.right;
            else if (x.left.max < lo)           x = x.right;
            else                                x = x.left;
        }
        return null;
    }

    @Override
    public void delete(Double lo, Double hi) {

    }

    @Override
    public Iterable<Interval> intersects(Double lo, Double hi) {
        return null;
    }
}
