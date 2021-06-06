package com.alex.andreiev.stack;

import java.util.Iterator;

//linked-list approach
// Every operation takes constant time in the worst case.
// A stack with N items uses ~40N bytes

public class StackLinkedList<T> extends Stack<T>{
    private Node first;

    @Override
    public void push(T item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
        size++;
    }

    @Override
    public T pop() throws Exception {
        super.pop();
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class Node
    {
        T item;
        Node next;
    }

    private class ListIterator implements Iterator<T>
    {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
