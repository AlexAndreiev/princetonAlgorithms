package com.alex.andreiev.balancedSearchTree;

/* B-Tree
* Generalize 2-3 trees by allowing up to M-1 key-link pairs per node.
*  Note: choose M as large as possible so that M links fit in a page, e.g., M = 1024
*   - At least 2 key-link pairs at root
*   - At least M/2 key-link pairs on other nodes
*   - External nodes contain client keys.
*   - Internal nodes contain copies of keys to guide search
*
* Searching in a B-tree
*   - start at root
*   - find interval for search key and take corresponding link
*   - search terminates in external node
*
* Insertion in a B-tree
*   - Search for new key
*   - Insert at bottom
*   - Split nodes with M key-link pairs on the way up the tree
*
* Proposition. A search or an insertion in a B-tree of order M with N keys requires
* between log base(M-1) N and log base(M/2) N probes
* Proof. All internal nodes (besides root) have between M/2 and M-1 links
*
* In practice. Number of probes is at most 4. (M = 1024; N = 62 billion log base(M/2) N <= 4
*
* Optimization. Always keep root page in memory
* */

public class BTree {
}
