package com.alex.andreiev.dynConnectivity;

import java.util.stream.IntStream;

public abstract class UnionFind {
    protected int[] id;

    public UnionFind(int N) // initialize union-find data structure with N objects (0 to N-1)
    {
        id = new int[N];
        IntStream.range(0, N).forEach(i -> id[i] = i);  // set id each object to utself (N array accesses)
    }

    public abstract void union(int p, int q);   // add connection between p and q
    public abstract boolean connected(int p, int q);    // are p and q in the same component?
    public abstract int find(int p);    // component identifier for p(0 to N-1)
    public abstract int count();    // number of components
}
