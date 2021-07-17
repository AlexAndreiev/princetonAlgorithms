package com.alex.andreiev.balancedSearchTree.geomApplications;

/* 1 dimension range search
*   - Insert key-value pair
*   - Search for key k
*   - Delete key k
*   - Range search: find all keys between k1 and k2
*   - Range count: number of keys between k1 and k2
*
* Application. Database queries
* Geometric interpretation:
*   - keys are point on a line
*   - find/count points in a given 1d interval
*
* Implementation:
*   - Unordered array. Fast insert, slow range search
*   - Ordered array. Slow insert, binary search for k1 and k2 to do range search
*   - Better choice - Binary ST implementation:
*
* */

public class OneDimRangeSearch {

    /* count
    * Proposition. Running time proportional to logN
    * Pf. Nodes examined = search path to lo + search path to hi
    * */
//    public int size(Key lo, key hi) {
//        //rank - number of keys < hi
//        if (contains(hi))   return rank(hi) - rank(lo) + 1;
//        else                return rank(hi) - rank(lo);
//    }

    /* search. Find all keys between lo and hi
    *   - Recursively find all keys in left subtree (if any could fall in range)
    *   - Check key in current node
    *   - Recursively find all keys in right subtree (if any could fall in range)
    * Proposition. Running time proportional to R + logN
    * */
}
