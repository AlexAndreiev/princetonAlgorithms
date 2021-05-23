package com.alex.andreiev.queue;

public class QueueLinkedList<T> extends Queue<T> {
    Node first;
    Node last;

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){
            first = last;
            size++;
            return;
        }
        oldLast.next = last;
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        T item = super.dequeue();
        item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        size--;
        return item;
    }

    private class Node{
        T item;
        Node next;
    }
}
