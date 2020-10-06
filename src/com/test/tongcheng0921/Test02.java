package com.test.tongcheng0921;

public class Test02 {


    public int countNBits (int num) {
        // write code here
        int bits = 0 ;
        int mask = 1;
        for(int i = 0 ; i < 32 ; i++){
            if((num&mask)!=0)
                bits++;
            mask <<= 1;
        }
        return bits;
    }

    public int[] countBits (int num) {
        // write code here
        int[] list = new int[num+1];
        int count = 0;
        for(int i = 0 ; i < num+1;i++){
            list[i] = countNBits(i);
        }
        return list;
    }
}
