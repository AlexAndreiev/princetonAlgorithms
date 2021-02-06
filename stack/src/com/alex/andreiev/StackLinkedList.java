package com.alex.andreiev;

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

    private class Node
    {
        T item;
        Node next;
    }
}
