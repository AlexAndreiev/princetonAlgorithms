package com.alex.andreiev.queue;

import java.util.Iterator;

public class QueueLinkedList<T> extends Queue<T> {
    Node first;
    Node last;

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()){ // special case for empty queue
            first = last;
            size++;
            return;
        }
        oldLast.next = last;
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        super.dequeue();
        var item = first.item;
        first = first.next;
        if (isEmpty())  // special case for empty queue
            last = null;
        size--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            var res = current;
            current = current.next;
            return res.item;
        }
    }

    private class Node{
        T item;
        Node next;
    }
}
