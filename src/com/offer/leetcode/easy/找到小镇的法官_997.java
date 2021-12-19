package com.offer.leetcode.easy;

class Leetcode_997 {


    public int findJudge(int n, int[][] trust) {
        int[] inDegrees = new int[n+1];
        int[] outDegrees = new int[n+1];

        for(int i = 0 ; i < trust.length; i++){
            //统计信任矩阵中的每个节点的入度以及出度
            outDegrees[trust[i][0]]++;
            inDegrees[trust[i][1]]++;
        }
        //寻找入度为n-1, 出度为0的节点,并将其节点信息返回, 没有则返回-1
        for(int i = 1 ; i < inDegrees.length ; i++){
            if(inDegrees[i] == n - 1 && outDegrees[i] == 0){
                return i;
            }
        }
        return -1;
    }

}
