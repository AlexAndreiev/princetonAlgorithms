package com.alex.andreiev.dynConnectivity;

public class QuickUnionImproved extends QuickUnion{
    int [] treeSize;

    public QuickUnionImproved(int N) {
        super(N);
        treeSize = new int[N];
     //   IntStream.range(0, N).forEach(i -> sz[i] = 1);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);

        if (pRoot == qRoot) return;

        if (treeSize[pRoot] < treeSize[qRoot]) {
            id[pRoot] = id[qRoot];
            treeSize[qRoot] += treeSize[pRoot];
        } else {
            id[qRoot] = id[pRoot];
            treeSize[pRoot] += treeSize[qRoot];
        }
    }

    @Override
    protected int getRoot(int index) {
        while (id[index] != index) {
            id[index] = id[id[index]];
            index = id[index];
        }
        return index;
    }
}
