package com.offer.Sorts;

/**
 *
 */
public class Test {

    public static void printArray(int[] array,String name){
        System.out.println("------------------------"+name+"-----------------------");
        for(int i = 0 ; i < array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
        System.out.println("--------------------------------------------------------");
    }

    public static void  test(Sort sort){
        int[] array = new int[]{12,31,536,234,64,23,64,23,75,8,3,46,78};
        sort.sort(array);
        printArray(array,sort.getClass().getName());
    }

    public static void main(String[] args){
        //插入排序
        InsertSort insertSort = new InsertSort();
        Test.test(insertSort);
        //折半插入排序
//        insertSort.halfInsertSort(array);
//        Test.printArray(array,"halfInsertSort");
        //希尔排序
        ShellSort shellSort = new ShellSort();
        Test.test(shellSort);
        //冒泡排序
        BubbleSort bubbleSort = new BubbleSort();
        Test.test(bubbleSort);
        //快速排序
        QuickSort quickSort = new QuickSort();
        Test.test(quickSort);
        //堆排序
        HeapSort heapSort = new HeapSort();
        Test.test(heapSort);
    }
}
