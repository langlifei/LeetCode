package com.offer.leetcode.easy;

public class 寻找二维数组中的某个数 {

    private static boolean isExist(int[][] arrays,int target){
        int i = 0;
        int j = 0;
        boolean isR = false;
        while(i<arrays.length&&j<arrays[0].length){
            if(arrays[i][j]==target)
                return true;
            else if(target>arrays[i][j])
                j++;
            else if(target<arrays[i][j]&&j!=0){
                j--;//回退一步
            }

        }
        return false;
    }


    public static void main(String[] args) {
        int[][] arrays = new int[6][5];
        arrays[0]= new int[]{1,4,7,11,15};
        arrays[1]= new int[]{2,5,8,12,19};
        arrays[2]= new int[]{3,6,9,16,22};
        arrays[3]= new int[]{10,13,14,17,24};
        arrays[4]= new int[]{18,21,23,26,30};
        System.out.println(isExist(arrays,10));
    }
}
