package com.offer.Sorts;

/**
 * 思想：每次将一个待排序的记录，按其关键字大小插入到前面已经排好序的子序列中，直到全部记录插入完成。
 *      注：由于每个子序列都是已经拍好序的，故可用二分查找直接找到比待插入关键字小的位置，之后进行移位。
 * 场景：适用于基本有序和数据量不大的排序表。
 * 时间复杂度o(n^2),空间复杂度o(1),稳定。
 */
public class InsertSort implements Sort{

    public void sort(int[] array){
        int temp = 0;
        int i,j;
        for(i = 1 ; i < array.length;i++){
            if(array[i]<array[i-1]){
                temp = array[i];
                for(j = i-1;j>=0&&array[j]>temp;j--){
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
    }

    public void halfInsertSort(int[] array){
        int temp = 0;
        int i , j ;
        int low,hight,mid;
        for(i = 1;i < array.length;i++){
            if(array[i]<array[i-1]){
                temp = array[i];
                low = 0;
                hight = i-1;
                while(low<=hight){
                    mid = (low+hight)/2;
                    if(array[mid]>temp)
                        hight = mid -1;
                    else
                        low = mid +1;
                }
                for(j = i-1;j>=hight+1;j--)//hight为数组中从temp的位置向左数，第一个小于temp的数。
                    array[j+1] = array[j];
                array[hight+1] = temp;
            }
        }

    }

}
