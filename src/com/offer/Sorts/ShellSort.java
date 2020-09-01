package com.offer.Sorts;

/**
 * 思想：使用不同的步数，来对关键字进行插入排序，步数最后为1时，就是普通的插入排序。
 * 场景：仅使用于线性表为顺序存储的情况，因为其依赖于顺序存储随机存取的特性。
 * 复杂度：其时间复杂度取决于增量的初始化，最坏时间复杂度为o(n^2),空间复杂度为o(1)，不稳定。
 */
public class ShellSort implements Sort{

    public void sort(int[] array){
        int temp;
        int i,j;
        for(int dk = array.length/2;dk>0;dk/=2){ //dk表示步长。
            for(i = dk;i<array.length;i++){
                if(array[i-dk]>array[i]){
                    temp = array[i];
                    for(j = i-dk;j>=0&&array[j]>temp;j-=dk) //适用插入排序，步数为dk;
                        array[j+dk] = array[j];
                    array[j+dk] = temp;
                }
            }
        }

    }
}
