package com.alex.andreiev;

import java.util.Iterator;

//linked-list approach
public class StackLinkedList<T> extends Stack<T>{
    private Node first;

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
        return null;
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
