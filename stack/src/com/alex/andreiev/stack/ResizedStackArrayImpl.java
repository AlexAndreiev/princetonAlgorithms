package com.alex.andreiev.stack;

// Every operation takes constant amortized time
// Less wasted space

// Starting from an  empty stack, any sequence of M push and pop operations tales time proportional to M
// Worst case:
// construct = 1
// push = N
// pop = N
// size = 1

public class ResizedStackArrayImpl<T> extends StackArrayImpl<T> {

    public ResizedStackArrayImpl() {
        super(1);
    }

    @Override
    public void push(T item) {
        if (size == s.length)
            resize(s.length * 2);
        super.push(item);
    }

    @Override
    public T pop() throws Exception {
        T item = super.pop();
        if (size == s.length/4)
            resize(s.length/2);
        return item;
    }

    private void resize(int capacity){
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            copy[i] = s[i];
        s = copy;
    }
}
