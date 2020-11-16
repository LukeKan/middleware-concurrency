package com.polimi.prefixsum;

public class PrefixCount extends Thread{
    protected int[] inputArr;
    protected int end_index, start_index;
    private int sum;
    public PrefixCount(int[] in, int start_index,int end_index){
        super();
        this.inputArr=in;
        this.start_index=start_index;
        this.end_index=end_index;
    }

    @Override
    public void run() {
        for(int i=start_index; i<end_index;i++){
            if(inputArr[i] % 3 == 0) sum++;
        }
    }


    public int getSum() {
        return sum;
    }
}
