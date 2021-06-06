package com.alex.andreiev.queue;

import java.util.Iterator;

public class QueueArrayImpl<T> extends Queue<T> {

    private T[] arr;
    private int head, tail;

    public QueueArrayImpl(){
        arr = (T[]) new Object[1];
        head = tail = 0;
    }

    public void enqueue(T item) {
        arr[tail++] = item;

        if (tail - head == arr.length) // all elements are taken
            rearrange(arr.length * 2);
        else if (tail == arr.length && head != 0)
            rearrange(arr.length); //just move elements to the array's beginning
    }

    @Override
    public T dequeue() throws Exception {
        super.dequeue();
        T item = arr[head];
        arr[head++] = null;
        if (tail - head < arr.length/4) // all elements are taken
            rearrange(arr.length / 2);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int getSize() {
        return tail - head;
    }

    private void rearrange(int length)
    {
        var newArr = (T[]) new Object[length];
        int j = 0;
        for (int i = head; i < tail; i++)
            newArr[j++] = arr[i];
        arr = newArr;
        tail = tail - head;
        head = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T>{
        private int current = head;

        @Override
        public boolean hasNext() {
            return current < tail;
        }

        @Override
        public T next() {
            return arr[current++];
        }
    }
}
