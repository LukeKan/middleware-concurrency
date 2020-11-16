package com.polimi.buffer;

import java.util.Queue;

public class ThreadPull extends ThreadBuffer {
    public ThreadPull(Queue<Integer> buffer, Integer max_size) {
        super(max_size, buffer);
    }
    
    @Override
    public void run(){
        synchronized (buffer) {
            while (this.buffer.size() == 0) {
                try {
                    System.out.println("waiting...");
                    this.buffer.wait();
                } catch (Exception e) {
                   e.printStackTrace();
                }
            }
            this.buffer.poll();
            System.out.println("removed 1");
            try {
                this.buffer.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
