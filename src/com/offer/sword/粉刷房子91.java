package com.offer.sword;

import java.util.Arrays;

/**
 * @Author: zz
 * @Date: 2022/6/25 10:44
 */
class Solution91 {

    public int minCost(int[][] costs) {
        if(costs.length == 1){
            return Arrays.stream(costs[0]).min().getAsInt();
        }
        int len = costs.length;
        for(int i = 1 ; i < len ; i++){
            costs[i][0] = Math.min(costs[i][0] + costs[i-1][1],costs[i][0] + costs[i-1][2]);
            costs[i][1] = Math.min(costs[i][1] + costs[i-1][0],costs[i][1] + costs[i-1][2]);
            costs[i][2] = Math.min(costs[i][2] + costs[i-1][0],costs[i][2] + costs[i-1][1]);
        }
        return Arrays.stream(costs[len-1]).min().getAsInt();
    }

    public static void main(String[] args) {
        new Solution91().minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}});
    }
}
