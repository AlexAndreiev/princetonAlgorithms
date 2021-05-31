package com.alex.andreiev.symbolTable;

public interface SymbolTable<Key, Value> {

    void put(Key key, Value val);
    Value get(Key key);
    void delete(Key key);
    boolean isEmpty();
    int size();
    Iterable<Key> keys();
}
