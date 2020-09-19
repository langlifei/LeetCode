package com.test;

public class XJ0917 {


    public void maxPrice(int[] array){
        if(array == null || array.length <= 0)
            return ;
        int max = Integer.MIN_VALUE;//最大价值
        int n = array.length;//长度
        int[] pickUp = new int[n];//决策列表
        int m = 1;//总能量
        for(int i = 1 ; i < array.length ; i++){

        }
    }

    public static void main(String[] args) {
        XJ0917 test = new XJ0917();
        test.maxPrice(new int[]{4,0,4,1,-3,4,3,2});
    }
}
