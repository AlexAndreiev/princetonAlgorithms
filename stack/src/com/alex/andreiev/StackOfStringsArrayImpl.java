package com.alex.andreiev;

public class StackOfStringsArrayImpl extends Stack {
    protected String[] s;
    private int capacity;

    public StackOfStringsArrayImpl(int capacity){
        this.capacity = capacity;
        s = new String[capacity];
    }

    public String pop() throws Exception{
        super.pop();
        String item = s[--size];
        s[size] = null;
        return item;
    }

    @Override
    public void push(String item) {
        s[size++] = item;
    }
}
