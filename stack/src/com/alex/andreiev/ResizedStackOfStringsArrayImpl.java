package com.alex.andreiev;

public class ResizedStackOfStringsArrayImpl extends StackOfStringsArrayImpl{

    public ResizedStackOfStringsArrayImpl() {
        super(1);
//        s = new String[1];
    }

    @Override
    public void push(String item) {
        if (size == s.length)
            resize(s.length * 2);
        super.push(item);
    }

    @Override
    public String pop() throws Exception {
        String item = super.pop();
        if (size == s.length/4)
            resize(s.length/2);
        return item;
    }

    private void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i = 0; i < size; i++)
            copy[i] = s[i];
        s = copy;
    }
}
