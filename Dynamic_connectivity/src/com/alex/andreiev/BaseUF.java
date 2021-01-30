package com.alex.andreiev;

import java.util.stream.IntStream;

public class BaseUF {
    protected int[] id;

    public BaseUF(int N)
    {
        id = new int[N];
        IntStream.range(0, N).forEach(i -> id[i] = i);
    }

}
