package com.alex.andreiev.dynConnectivity;

//tree approach - is also too slow
// Const model. Number of array accesses (for read and write)
// initialize - N
// union - N (includes cost of finding roots)
// find - N (worst case)

//Quick-find defect.
// ・Union too expensive (N array accesses).
// ・Trees are flat, but too expensive to keep them flat.
//
// Quick-union defect.
// ・Trees can get tall.
// ・Find too expensive (could be N array accesses).

public class QuickUnion extends UnionFind {

    protected int componentCount;

    public QuickUnion(int N) {
        super(N);
        componentCount = N;
    }

    // depth of p and q array accesses
    public void union(int p, int q)
    {
        if (p == q) return;
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if (pRoot != qRoot) {
            id[pRoot] = id[qRoot];
            componentCount--;
        }
    }

    // depth of p and q array accesses
    @Override
    public boolean connected(int p, int q)
    {
        return getRoot(p) == getRoot(q);
    }

    @Override
    public int find(int p) {
        return getRoot(p);
    }

    @Override
    public int count() {
        return componentCount;
    }

    // depth of i array accesses
    protected int getRoot(int index){
        while (id[index] != index)
            index = id[index];
        return index;
    }
}
