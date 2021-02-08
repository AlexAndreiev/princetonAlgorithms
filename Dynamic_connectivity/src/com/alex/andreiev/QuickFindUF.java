package com.alex.andreiev;

public class QuickFindUF extends BaseUF {

    public QuickFindUF(int N) {
        super(N);
    }

    public void union(int p, int q)
    {
        if (connected(p, q))
            return;
        for (int i = 0; i < id.length-1; i++)
            if (id[i] == id[p])
                id[i] = id[q];
    }

    public boolean connected(int p, int q)
    {
        return id[p] == id[q];
    }
}
