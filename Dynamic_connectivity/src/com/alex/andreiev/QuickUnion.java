package com.alex.andreiev;

import java.util.stream.IntStream;

//tree approach
public class QuickUnion extends BaseUF{

    public QuickUnion(int N) {
        super(N);
    }

    public void union(int p, int q)
    {
        if (p == q) return;
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        id[pRoot] = id[qRoot];
    }

    public boolean connected(int p, int q)
    {
        return getRoot(p) == getRoot(q);
    }

    protected int getRoot(int index){
        while (id[index] != index)
            index = id[index];
        return index;
    }
}
