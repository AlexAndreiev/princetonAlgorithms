package com.alex.andreiev.stack;

public abstract class Stack<T> implements Iterable<T> {
    protected int size = 0;
    public abstract void push(T item);
    public T pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return null;
    }
    public boolean isEmpty() { return size == 0; }
    public int getSize() { return size; }
}
