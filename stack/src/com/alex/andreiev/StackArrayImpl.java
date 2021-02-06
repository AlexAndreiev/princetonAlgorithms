package com.alex.andreiev;

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
}
