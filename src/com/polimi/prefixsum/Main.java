package com.polimi.prefixsum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static int[] input = {0,1,2,3,4,5,6,7,8,9,10,11};
    private static final int threadNumber = 4;

    public static void main(String[] args) throws InterruptedException {
        // check illegal input size
        if(input.length%4!=0)return;

        // count threads
        List<PrefixCount> prefixCount = new ArrayList<>();
        int sized = input.length/threadNumber;
        PrefixCount nowCount;
        for(int i=0; i<threadNumber; i++){
            int end = (i+1) * sized;
            nowCount = new PrefixCount(input,i*sized,end);
            prefixCount.add(nowCount);
            nowCount.start();
        }

        int out_sum= 0;
        for ( PrefixCount elem: prefixCount) {
            elem.join();
            out_sum += elem.getSum();
        }
        System.out.println("Count = "+out_sum);

        // compute threads
        int[] output = new int[out_sum];
        List<PrefixCompute> prefixCompute = new ArrayList<>();
        PrefixCompute nowCompute;
        for(int i=0; i<threadNumber; i++){
            int end = (i+1) * sized;
            nowCompute = new PrefixCompute(input,output,i*sized,end);
            prefixCompute.add(nowCompute);
            nowCompute.start();
        }
        for (PrefixCompute elem : prefixCompute){
                elem.join();
        };

        //result
        System.out.print("[");
        for (int i : output) {
            System.out.print(" "+i);
        }
        System.out.print(" ]");
    }

}
