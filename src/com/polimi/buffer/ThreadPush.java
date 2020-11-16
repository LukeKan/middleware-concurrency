package com.polimi.buffer;

import java.util.Queue;

public class ThreadPush extends ThreadBuffer{
    public ThreadPush(Queue<Integer> buffer, int max_size) {
        super(max_size, buffer);
    }

    @Override
    public void run(){
        synchronized (buffer) {
            while (this.buffer.size() == max_size) {
                try {
                    System.out.println("waiting...");
                    this.buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.buffer.add(1);
            System.out.println("added 1");
            try {
                this.buffer.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
