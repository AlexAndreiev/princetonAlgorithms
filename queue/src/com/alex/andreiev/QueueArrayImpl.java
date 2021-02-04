package com.alex.andreiev;

public class QueueArrayImpl extends QueueOfStrings {

    private String[] arr;
    private int head, tail;

    public QueueArrayImpl(int capacity){
        arr = new String[capacity];
        head = tail = 0;
    }

    public void enqueue(String item) throws Exception {
        if (tail == arr.length)
            throw new Exception("Queue is full.");

        arr[tail++] = item;

        if (tail == arr.length && head != 0)
            rearrange();
    }

    @Override
    public String dequeue() throws Exception {
        String item = super.dequeue();
        item = arr[head];
        arr[head++] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    private void rearrange()
    {
        String newArr[] = new String[arr.length];
        int j = 0;
        for (int i = head; i < tail; i++)
            newArr[j++] = arr[i];
        newArr = arr;
        tail = tail - head;
        head = 0;
    }

}
