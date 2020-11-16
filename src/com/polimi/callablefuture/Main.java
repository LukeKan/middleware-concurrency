package com.polimi.callablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Integer>> step1 =
                Arrays.asList(
                        () -> {
                            return new Random().nextInt(100);
                        },
                        () -> {
                            int rndNum = new Random().nextInt(100);
                            Thread.sleep(1000);
                            return rndNum;
                        },
                        () -> {
                            int rndNum = new Random().nextInt(100);
                            Thread.sleep(2000);
                            return rndNum;
                        }
                );

        int temp1 = executorService.invokeAny(step1);
        System.out.println("step1= "+temp1);
        List<Callable<Integer>> step2 =
                Arrays.asList(
                        () -> {
                            Thread.sleep(2000);
                            return  temp1*2;
                        },
                        () -> {
                            int t2 = temp1*3;
                            Thread.sleep(1000);
                            return t2;
                        },
                        () -> {
                            int t2 = temp1*4;

                            return t2;
                        }
                );
        int temp2 = executorService.invokeAny(step2);
        System.out.println("step2= "+temp2);
        List<Callable<String>> step3 =
                Arrays.asList(
                        () -> {
                            Thread.sleep(2000);
                            return "A";
                        },
                        () -> {
                            return "B";
                        },
                        () -> {
                            Thread.sleep(1000);
                            return "C";
                        }
                );
        System.out.println( "step3= "+executorService.invokeAny(step3));
        return;
    }
}
