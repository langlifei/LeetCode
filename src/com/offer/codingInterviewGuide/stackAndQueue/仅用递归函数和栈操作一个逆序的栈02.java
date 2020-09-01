package com.offer.codingInterviewGuide.stackAndQueue;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/1 10:28
 * @Describe   学会对问题进行拆分。
 */

class stack03 {

    //用临时变量存储着被pop出来的值，以便通过栈空来判断是否为最后一个元素，
    // 之后将其他元素重新压会栈
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int value = stack.pop();
        if(stack.isEmpty())
            return value;
        int m = getAndRemoveLastElement(stack);
        stack.push(value);
        return m;
    }

    //每次获取最后一个元素，当栈空时，即是将第一个、第二个 依次压入栈，从而使得链表翻转。
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty())
            return ;
        int i = getAndRemoveLastElement(stack);
        reverse(stack);//一直反转到最后一个元素后开始压入栈，即第一个被压入的就是先前的第一个元素
        stack.push(i);
    }

}
