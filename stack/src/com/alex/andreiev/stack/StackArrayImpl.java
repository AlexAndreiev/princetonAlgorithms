package com.alex.andreiev.stack;

import java.util.Iterator;

public class StackArrayImpl<T> extends Stack<T> {
    protected T[] s;
    private int capacity;

    public StackArrayImpl(int capacity){
        this.capacity = capacity;
        s = (T[]) new Object[capacity];
    }

    public T pop() throws Exception{
        super.pop();
        T item = s[--size];
        s[size] = null;
        return item;
    }

    @Override
    public void push(T item) {
        s[size++] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T>{
        private int current = capacity;
        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public T next() {
            return s[--current];
        }
    }
}
