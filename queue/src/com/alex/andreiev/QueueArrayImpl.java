package com.alex.andreiev;

public class QueueArrayImpl extends QueueOfStrings {

    private String[] arr;
    private int head, tail;

    public QueueArrayImpl(){
        arr = new String[1];
        head = tail = 0;
    }

    public void enqueue(String item) throws Exception {
        arr[tail++] = item;

        if (tail - head == arr.length) // all elements are taken
            rearrange(arr.length * 2);
        else  if (tail == arr.length && head != 0)
            rearrange(arr.length); //just move elements to the array's beginning
    }

    @Override
    public String dequeue() throws Exception {
        String item = super.dequeue();
        item = arr[head];
        arr[head++] = null;
        if (tail - head < arr.length/4) // all elements are taken
            rearrange(arr.length / 2);
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    private void rearrange(int length)
    {
        String newArr[] = new String[length];
        int j = 0;
        for (int i = head; i < tail; i++)
            newArr[j++] = arr[i];
        arr = newArr;
        tail = tail - head;
        head = 0;
    }
}
