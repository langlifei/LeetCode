package com.offer.Sorts;

/**
 * 思想：将待排序列构成一个最大堆，此时，整个序列的最大值就是堆顶的根节点，将其与末尾元素进行交换，此时末尾就是最大值，然后将n-1个元素重新构成最大堆，找到次小值，一直找到底。
 * 特点：堆顶的元素是最大(小)的，常用于优先级队列。
 * 复杂度：[o(nlogn),o(1),不稳定]
 */
public class HeapSort implements Sort{
    @Override
    public void sort(int[] array) {
        int temp;
        //建立最大堆。
        for(int i = (array.length-2)/2;i>=0;i--)//i的左子树为2i+1,右子树为2i+2,故其父节点的位置为(array.length-1-1)/2,下标从0开始。
            adjustDown(array,i,array.length);
        //将根节点(最大值)交换到数组的末尾，由于交换后可能破坏最大堆的结构，故需对最大堆进行重新调整
        for(int i = array.length-1;i>0;i--){
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustDown(array,0,i);//长度逐渐缩小，将根节点调整为子序列的最大值。
        }
    }

    public void adjustDown(int[] array,int k,int len){
            int temp;
            for(int l = 2*k+1;l<len;l=2*k+1){
                if(l+1<len&&array[l]<array[l+1])//让l指向左右节点中大的一个，如果存在右节点，且右节点大于左节点，则l指向右节点。
                    l++;
                if(array[k]>=array[l])//如果父节点大于子节点，则直接退出。
                    break;
                else{
                    temp = array[k];
                    array[k] = array[l];
                    array[l] = temp;
                    //由于交换后可能破坏了最大堆的性质，故需重新调度此方法。
                    k = l;
                }
            }
    }
}
