package com.offer.sword;

/*
*                   时间:2020年3月3日09:24:33
*                   地点:湖北省仙桃市
*                   问题:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
*                        每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
*                        个整数，判断数组中是否含有该整数
*                   通过率:50%
*                   原因:只考虑了二维数组是方阵的情况.
* */

public class array01 {

    public boolean Find(int target, int [][] array) {
        /*
            没有考虑到二维数组不一定是方阵的情况 通过率 41.18%.
        */
        //从第一行最后一列开始
        int rows = array.length-1;
        int columns = array[0].length -1;
        int i = 0;
        int j = columns;
        while(i <= rows && j >= 0){
            if(array[i][j] > target){
                j--;
            }else if(array[i][j] < target){
                i++;
            }else
                return true;
        }
        return false;
    }
}
