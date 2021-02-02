package com.alex.andreiev;

public class QueueLinkedList extends QueueOfStrings {
    Node first;
    Node last;

    @Override
    public void enqueue(String item) {
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
    public String dequeue() throws Exception {
        String item = super.dequeue();
        item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        size--;
        return item;
    }

    private class Node{
        String item;
        Node next;
    }
}
