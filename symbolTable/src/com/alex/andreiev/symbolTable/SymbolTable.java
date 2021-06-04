package com.alex.andreiev.symbolTable;

//sequential search (unordered link list)
// binary search (ordered array)
// binary tree

public class SymbolTable<Key, Value> implements ISymbolTable<Key, Value>{

    private int N = 0;


    @Override
    public void put(Key key, Value val) {

    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = Utils.rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return vals[i];
        else
            return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
