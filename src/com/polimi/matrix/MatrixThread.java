package com.polimi.matrix;

public class MatrixThread extends Thread{

    private Integer[] rowA, rowB, res;
    public MatrixThread(Integer[] rA,Integer[] rB,Integer[] rs){
        rowA = rA;
        rowB = rB;
        res = rs;
    }


    public void run(){
        for(int i=0; i < rowA.length;i++){
            res[i]=rowA[i] + rowB[i];
        }
    }
}
