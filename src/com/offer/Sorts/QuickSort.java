package com.offer.Sorts;

/**
 *  思想：基于分而治之法对冒泡算法进行改进，将比pivot小的数全放到左边，比pivot大的数放到右边，退出循环时的位置就是pivot。
 *  * 特点：不产生有序子序列，但每一趟排序将一个元素(基准元素)放到其最终的位置上。
 *  * 复杂度：[o(nlogn),o(logn),不稳定]
 */
public class QuickSort implements Sort{

    @Override
    public void sort(int[] array) {
        QuickSort(array,0,array.length-1);
    }

    public void QuickSort(int[] array,int low,int high){
        if(low<high){
            int pivotpos = partition(array,low,high);
            //对左边进行划分
            QuickSort(array,low,pivotpos-1);
            //对右边进行划分
            QuickSort(array,pivotpos+1,high);
        }
    }

    public int partition(int[] array,int low,int high){
        int pivot = array[low];//取表中的第一个元素为中心点。
        while(low<high){//low=high的时候退出。
            while(low<high&&array[high]>=pivot)//先从右找小于pivot的数，存到array[low]下。
                high--;
            array[low] = array[high];
            while(low<high&&array[low]<=pivot)//从左找大于pivot的数，存到array[high]上。
                low++;
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}
