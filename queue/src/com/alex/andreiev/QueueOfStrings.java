package com.alex.andreiev;

public abstract class QueueOfStrings {
    int size = 0;

    public QueueOfStrings(){
    }

    abstract void enqueue(String item) throws Exception;

    public String dequeue() throws Exception {
        if (isEmpty()) throw new Exception("Queue is empty");
        return "";
    }

    public boolean isEmpty() { return getSize() == 0; }

    public int getSize(){ return size; }
}
