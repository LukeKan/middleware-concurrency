package com.polimi.threadpool;

public class PrefixCompute extends PrefixCount {
    private int[] outputArr;
    private static int out_index=0;

    public PrefixCompute(int[] in, int[] out, int start,int end, int[] sum) {
        super(in,start,end, sum);
        outputArr=out;
    }

    @Override
    public void run() {
        for (int i = this.start_index; i < this.end_index; i++) {
            if (this.inputArr[i] % 3 == 0) {
                this.outputArr[out_index]=this.inputArr[i];
                out_index++;
            }
        }

    }
}
