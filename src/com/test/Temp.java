package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Temp {

    public int maxCandies (int[] candies, int[] coin, int n) {
        // write code here
        if(candies == null || candies.length<=0 || coin== null || coin.length==0 || n <0)
            return 0;
        int max = 0;
        int res = 0;
        int temp = 0;
        for(int i = 0 ; i < candies.length ; i++){
            if(coin[i] == 0)
                res += candies[i];
            else
                temp += candies[i];
            if( i >= n){
                if(coin[i-n]==1)
                    temp = temp-candies[i-n];
                max = Math.max(max, temp);
            }
        }
        return res+Math.max(max,temp);
    }

    public static void main(String[] args) {
        Temp temp = new Temp();
        System.out.println(temp.maxCandies(new int[]{3,5,7,2,8,8,15,3},new int[]{1,0,1,0,1,0,1,0}, 3));
    }
}
