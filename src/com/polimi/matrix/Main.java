package com.polimi.matrix;

import java.util.List;
import java.util.Vector;

public class Main {

    private static final int row_length = 20;
    private static final int col_length = 10;

    public static void main(String[] args) throws InterruptedException {
        /*MyThread t1,t2;
        t1=new MyThread("Thread_1");
        t2=new MyThread("Thread_2");
        t1.start();
        t2.start();*/

        Integer[][] matrixA, matrixB, result;
        matrixA= new Integer[row_length][col_length];
        matrixB= new Integer[row_length][col_length];
        for (int i=0;i<row_length;i++){
            for (int j=0; j<col_length;j++){
                matrixA[i][j]=i%4+j%2;
                matrixB[i][j]=i%3+j*2;
            }
        }
        result= new Integer[row_length][col_length];

        MatrixThread rowThreadA;
        List<MatrixThread> threads = new Vector<MatrixThread>();
        for(int i=0;i<row_length;i++){
            rowThreadA= new MatrixThread(matrixA[i],matrixB[i],result[i]);
            rowThreadA.start();
            threads.add(rowThreadA);
        }
        for (MatrixThread matrixThread : threads) matrixThread.join();

        for (Integer[] row : result){
            System.out.print("[ ");
            for (Integer element : row){
                System.out.print(element+" ");
            }
            System.out.print("]");
            System.out.println();
        }

    }
}
