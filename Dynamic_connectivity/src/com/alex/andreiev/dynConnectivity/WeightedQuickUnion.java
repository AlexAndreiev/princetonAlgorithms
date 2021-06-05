package com.alex.andreiev.dynConnectivity;

// weighted quick-union
// initialize - N
// union - lgN (includes cost of finding roots)
// connected - lgN (includes cost of finding roots)

public class WeightedQuickUnion extends QuickUnion{
    int [] treeSize;

    public WeightedQuickUnion(int N) {
        super(N);
        treeSize = new int[N];
    }

    @Override
    public void union(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);

        if (pRoot == qRoot) return;
        componentCount--;

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
