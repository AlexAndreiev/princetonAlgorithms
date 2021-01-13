package com.company;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q)
    {
        if (id[p] == id[q])
            return;
        int repVal = id[p];
        for (int i = 0; i < id.length-1; i++)
        {
            if (id[i] == repVal)
                id[i] = id[q];
        }
    }

    public boolean equals(int p, int q)
    {
        return id[p] == id[q];
    }
}
