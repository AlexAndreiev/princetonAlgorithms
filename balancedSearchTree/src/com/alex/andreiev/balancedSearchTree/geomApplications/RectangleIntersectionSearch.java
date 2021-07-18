package com.alex.andreiev.balancedSearchTree.geomApplications;

/* Goal. find all intersections among a set of N orthogonal rectangles
* Quadratic algorithm. Check all pairs of rectangles for intersection.
* Non-degeneracy assumption. All x- and y-coordinates are distinct
*
* Sweep-line algorithm:
*   - x-coordinates of left and right endpoints define events.
*   - maintain set of rectangles that intersect the sweep line in an interval search tree (using y-intervals of rectangle)
*   - left endpoint: interval search for y-interval of rectangle; insert y-interval
*   - right endpoint: remove y-interval
*
* Proposition. Sweep line algorithm tales time proportional to N log N + R log N to find R intersections
*   among a set on N rectangles
* Pf.
*   - put x-coordinates on a PQ (or sort)   -> N log N
*   - insert y-intervals into ST.           -> N log N
*   - delete y-intervals from ST            -> N log N
*   - interval searches for y-intervals     -> N log N + R log N
*
* Bottom line. Sweep line reduces 2d orthogonal rectangle intersection search to 1d interval search
*  */

public class RectangleIntersectionSearch {
}
