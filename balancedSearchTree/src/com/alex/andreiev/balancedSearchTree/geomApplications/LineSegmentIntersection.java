package com.alex.andreiev.balancedSearchTree.geomApplications;

/* Orthogonal line segment intersection search
* Given N horizontal and vertical line segments, find all intersections.
* Quadratic algorithm. Check all pairs of line segments for intersection
* Nondegeneracy assumption. All x- and y- coordinates are distinct
*
* Efficient algorithm: Sweep vertical line from left to right
*   - x-coordinates define events
*   - h-segment (left endpoint): insert y-coordinate into BST
*   - h-segment (right endpoint): remove y-coordinate from BST
*   - v-segment: range search for interval of y-endpoints
*
* Proposition. The sweep-line algorithm takes time proportional to N log N + R to find all R intersections
* among N orthogonal line segments
*
* Proof.
*   - Put x-coordinates on a PQ (or sort) -> N log N
*   - Insert y-coordinates into BST -> N log N
*   - Delete y-coordinates from BST -> N log N
*   - Range searches in BST -> N log N + R
* Bottom line. Sweep line reduces 2d orthogonal line segment intersection search to 1d range search
* */

public class LineSegmentIntersection {


}
