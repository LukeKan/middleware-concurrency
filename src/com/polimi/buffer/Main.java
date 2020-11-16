package com.polimi.buffer;

import java.util.*;

public class Main {
    private static final int max_size = 3;
    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> myQueue= new LinkedList<>();
        Random r = new Random();
        ThreadBuffer t;

        //processing buffers
        List<ThreadBuffer> eleThreads = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (r.nextBoolean()) {
                t = new ThreadPull(myQueue, max_size);
            } else {
                t = new ThreadPush(myQueue, max_size);
            }
            t.start();
            eleThreads.add(t);
        }

        for ( ThreadBuffer ts: eleThreads ) {
            ts.join();
        }
        System.out.println("done.");
    }
}
