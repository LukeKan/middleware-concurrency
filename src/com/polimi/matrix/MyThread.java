package com.polimi.matrix;

public class MyThread extends Thread{
    private String msg;

    public MyThread(String m){
        this.msg=m;
    }

    public void run(){
        for (int i=0; i<20;i++){
            System.out.println(this.msg);
        }
    }
}
