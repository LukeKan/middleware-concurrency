package com.polimi.threadpool;

import java.util.concurrent.*;

public class Main {

    private static int[] input = {0,1,2,3,4,5,6,7,8,9,10,11};
    private static final int threadNumber = 4;

    public static void main(String[] args) throws InterruptedException {
        int[] sum = {0};
        ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
        // check illegal input size
        if(input.length%4!=0)return;

        // count threads
        int sized = input.length/threadNumber;
        PrefixCount nowCount;
        for(int i=0; i<threadNumber; i++){
            int end = (i+1) * sized;
            nowCount = new PrefixCount(input,i*sized,end,sum);
            executorService.submit(nowCount);
        }
        executorService.awaitTermination(100,TimeUnit.MILLISECONDS);
        System.out.println("Count = "+sum[0]);

        // compute threads
        int[] output = new int [sum[0]];
        PrefixCompute nowCompute;
        for(int i=0; i<threadNumber; i++){
            int end = (i+1) * sized;
            nowCompute = new PrefixCompute(input,output,i*sized,end,sum);
            executorService.submit(nowCompute);
        }
        executorService.awaitTermination(100,TimeUnit.MILLISECONDS);

        // result
        System.out.print("[");
        for (int i : output) {
            System.out.print(" "+i);
        }
        System.out.print(" ]");

    }
}
