package com.alex.andreiev;

//linked-list approach
public class StackOfStringsLinkedList extends Stack{
    private Node first;
    private int size = 0;

    public void push(String item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
        size++;
    }

    @Override
    public String pop() throws Exception {
        super.pop();
        String item = first.item;
        first = first.next;
        size--;
        return item;
    }

    private class Node
    {
        String item;
        Node next;
    }
}
