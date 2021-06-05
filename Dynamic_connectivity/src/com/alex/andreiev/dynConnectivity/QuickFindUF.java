package com.alex.andreiev.dynConnectivity;

import java.util.Arrays;

// Quick find is too slow
// Cost model. Number of array accesses (for read or write)
// initialize - N
// union - N
// find - 1
// Union is too expensive. It takes N2(quadratic) arrays accesses to process a sequence of N union commands on N objects

public class QuickFindUF extends UnionFind {

    public QuickFindUF(int N) {
        super(N);
    }

    // at most 2N+2 array accesses
    public void union(int p, int q)
    {
        if (connected(p, q))
            return;
        int pId = id[p];
        for (int i = 0; i < id.length-1; i++)
            if (id[i] == pId)
                id[i] = id[q];
    }

    // 2 arrays accesses
    @Override
    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        if (id.length == 0) return 0;
        var tmp = id.clone();
        Arrays.sort(tmp);
        int count = 1;
        int val = id[0];
        for (int i = 0; i < tmp.length-1; i++) {
            if (val != tmp[i]) {
                val = tmp[i];
                count++;
            }
        }
        return  count;
    }
}
