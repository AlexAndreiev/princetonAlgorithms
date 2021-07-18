package com.alex.andreiev.balancedSearchTree.geomApplications;

/*KdTree (k-dimension). Recursively partition k-dimensional space into 2 halfspaces
* Implementation. BST, but cycle through dimensions ala 2d trees
* Efficient, simple data structure for processing k-dimensional data:
*   - widely user
*   - adapts well to high-dimensional and clustered data
*   - discovered by an undergrad in an algorithms class (Jon Bentley)
* */

/* 2 dimension orthogonal range search
* Extension of ordered symbol table to 2d keys
*   - Insert a 2d key
*   - Delete a 2d key
*   - Search for a 2d key
*   - Range search: find all keys that lie in a 2d range
*   - Range count: number of keys that lie in a 2d range
*
* Geometric interpretation. Fast, simple solution for evenly distributed points:
*   - Keys are point in the plane
*   - Find/count points in a given h-v rectangle (rectangle is axis-aligned)
* Application. Networking, circuit design, databases
*
*/

/* Grid implementation:
*   - Divide space into M-by-M grid of squares
*   - Create list of points contained in each square
*   - Use 2d array to directly index relevant square
*   - Insert: add (x, y) to list for corresponding square
*   - Range search: examine only squares that intersect 2d range query
* Space-time tradeoff:
*   - Space: M^2 + N
*   - Time: 1 + N/M^2 per square examined, on average
* Choose grid square size to tune performance:
*   - Too small: wasters space
*   - Too large: too many points per square
*   - Rule of thumb: sqrt(N)-by-sqrt(N) grid
*
* Running time. (if points are evenly distributed)
*   - Initialize data structure N
*   - Insert point: 1
*   - Range search: 1 per point in range
*
* Problem. Clustering a well-known phenomenon in geometric data
*   - list are too long, even though average length is short
*   - need data structure that adapts gracefully
* */

/* Space-partitioning trees implementation:
* Use a tree to represent a recursive subdivision of 2d space
* Grid. Divide space uniformly into squares
* 2d tree. Recursively divide space into two halfplanes.
* Quadtree. Recursively divide space into four quadrants.
* BSP tree. Recursively divide space into two regions
*
* Applications:
*   - Ray tracing, 2d range search, flight simulators, N-body simulation, collision detection,
*   astronomical databases, nearest neighbor search adaptive mesh generation, accelerate rendering in Doom,
*   hidden surface removal and shadow casting
*
* Data structure. BST, but alternate using x- and y-coordinates as key:
*   - Search gives rectangle containing point
*   - Insert further subdivides the plane
*
* Goal. Find all points in a query axis-aligned rectangle:
*   - check if point in node lies in given rectangle
*   - recursively search left/bottom (if any could fall in rectangle)
*   - recursively search right/top (if any could fall in rectangle)
*
* Typical case. R + log N
* Worst case (assuming tree is balanced). R + sqrt(N)
*
* Nearest neighbor search in a 2d tree
*   - Goal. Find closest point to query point:
*       - check distance from point in node to query point
*       - recursively search left/bottom (if it could contain a closer point)
*       - recursively search right/top (if it could contain a closer point)
*       - organize method so that it begins by searching for query point
*   Typical case. log N
*   Worst case (even if tree is balanced) N
*  */

/* N-body simulation
* Goal. Simulate the motion of N particles, mutually affected by gravity
* Brute force. For each pair of particles, compute force: F=(Gm1m2)/(r^2)
*
* Appel algorithm for N-body simulation
* Key idea. Suppose particle is far, far away from cluster of particles:
*   - treat cluster of particles as a single aggregate particle
*   - compute force between particle and center of mass of aggregate
* Steps:
*   - build 3d tree with N particles as nodes
*   - store center-of-mass of subtree in each node
*   - to compute total force action on a particle, traverse tree, but stop as soon as distance
*   from particle to subdivision is sufficiently large
* */

public class KdTree {
}
