package com.polimi.buffer;

import java.util.Queue;

public abstract class ThreadBuffer extends Thread{
    protected final int max_size;
    protected Queue<Integer> buffer;
    public ThreadBuffer(int max_size, Queue<Integer> buffer){
        this.max_size = max_size;
        this.buffer=buffer;
    }

}
