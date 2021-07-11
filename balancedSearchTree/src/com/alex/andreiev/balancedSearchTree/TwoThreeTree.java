package com.alex.andreiev.balancedSearchTree;

/* 2-3 tree
* Allow 1 or 2 keys per node.
*   - 2-node: one key, two children
*   - 3-node: two keys, three children
* Perfect balance. Every path from root to null link has same length
* Symmetric order. Inorder traversal yields keys in ascending order
* Search:
*   - compare search key against keys in node
*   - find interval containing search key
*   - follow associated link (recursively)
*
* Insert into a 2-node at bottom:
*   - search for key, as usual
*   - replace 2-node with 3-node
* Insert into a 3-node at bottom:
*   - add new key to 3-node to create temporary 4-node.
*   - move middle key in 4-node into parent
*   - repeat up the tree, as necessary
*   - if you reach the root and it's a 4-node, split it into three 2-nodes
*
* Splitting a 4-node is a local transformation: constant number of operations.
* Invariants. Maintains symmetric order and perfect balance.
* Perfect balance. Every path from root to null link has same length
*
* Thee height:
*   - Worst case: lg N. [all 2-nodes]
*   - Best case: log3 N ~ 0.631 lg N. [all 3-nodes]
*   - Between 12 and 20 for a million nodes
*   - Between 18 and 30 for a billion nodes
* Guaranteed logarithmic performance for search and insert.
*
* * Search(worst)   Insert(worst)   Delete(worst)   Search hit(avg)     insert(avg)     Delete(avg)     ordered iteration?   Key interface
*       c lgN          c lg N           c lgN           c lgN              c lgN             c lgN              yes           CompareTo()
*   constants depend upon implementation
*
* Direct implementation is complicated, because:
*   - Maintaining multiple node types is cumbersome
*   - Need multiple compares to move down tree
*   - Need to move back up the tree to split 4-nodes.
*   - Large number of cases for splitting
*
* Bottom line. Could do it, but there's a better way.
*
*  */



public class TwoThreeTree {
}
