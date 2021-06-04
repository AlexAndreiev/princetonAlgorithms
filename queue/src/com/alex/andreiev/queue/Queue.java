package com.alex.andreiev.queue;

public abstract class Queue<T> implements Iterable<T> {
    int size = 0;

    public Queue(){
    }

    public abstract void enqueue(T item) throws Exception;

    public T dequeue() throws Exception {
        if (isEmpty()) throw new Exception("Queue is empty");
        return null;
    }

    public boolean isEmpty() { return getSize() == 0; }

    public int getSize(){ return size; }
}
