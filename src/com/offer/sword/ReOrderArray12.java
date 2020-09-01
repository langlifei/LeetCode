package com.offer.sword;

/*
*                       时间:2020年3月7日14:01:49
*                       地点:湖北省仙桃市
*                       问题:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
*                            使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
*                            并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*                       结果:通过
*                       难点:保证其交换后相对位置不变.
* */

public class ReOrderArray12 {

    public void reOrderArray(int[] array){
        int index = -1;
        for(int i= 0 , j = array.length-1; i <j;i++,j--){
            //如果是偶数就与最近的奇数互换.
            if(array[i] % 2 == 0){
                index = f(array,i,0);
                while(index>i){
                    swap(array,index,index-1);
                    index--;
                }
            }
            //如果是奇数,就与最近的偶数互换
            if(array[j] % 2 != 0){
                index = f(array,j,1);
                while(index < j){
                    swap(array,index,index+1);
                    index++;
                }
            }
        }
    }

    /**
     *
     * @param array 数组
     * @param index 从index开始找
     * @param status 标志找奇数还是偶数,即从前往后找,还是从后往前找,0表示找奇数,1表示找偶数.
     * @return
     */
    public int f(int[] array,int index,int status){
        if(status == 0){
            while( index < array.length/2){
                index++;
                if(array[index] % 2 != 0)
                    return index;
            }
        }else{
            while( index > array.length/2){
                index--;
                if(array[index] % 2 == 0)
                    return index;
            }
        }
        return -1;
    }

    public void swap(int[] array, int i , int j){
        int temp = 0 ;
        temp = array[i];
        array[i] = array[j]  ;
        array[j] = temp;
    }

    public static void main(String[] args){
        ReOrderArray12 r = new ReOrderArray12();
        int[] array = new int[]{1,2,3,4,5,6,7};
        r.reOrderArray(array);
    }
}
