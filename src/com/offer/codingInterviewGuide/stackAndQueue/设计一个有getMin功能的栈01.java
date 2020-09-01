package com.offer.codingInterviewGuide.stackAndQueue;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/1 8:21
 * @Describe  提供两种解法
 *            1.时间消耗要多一点
 *            2.空间消耗要多一点
 *
 */

class stack01 {

    /**
     *    1.
     */
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public stack01(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }


    public void push(int value){
        if(stackMin.isEmpty())
            stackMin.push(value);
        else{
            //如果push的值比最小栈的栈顶元素小，则push到最小栈中
            if(value<=stackMin.peek()){
                stackMin.push(value);
            }
        }
        stackData.push(value);
    }

    public int pop(){
        if(stackData.isEmpty())
            return -1;
        int value = stackData.pop();
        //当pop出的是当前的最小值，需从最小值栈里将该元素移除
        if(!stackMin.isEmpty()&&value==stackMin.peek())
            stackMin.pop();
        return value;
    }

    public int getMin(){
        if (!stackMin.isEmpty())
            return stackMin.peek();
        else
            return -1;
    }

}

class stack02{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public stack02(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }


    public void push(int value){
        if(stackMin.isEmpty())
            stackMin.push(value);
        else{
            //如果push的值比最小栈的栈顶元素小，则push到最小栈中
            if(value<=stackMin.peek()){
                stackMin.push(value);
            }else{
                stackMin.push(stackMin.peek());
            }
        }
        stackData.push(value);
    }

    public int pop(){
        if(stackData.isEmpty())
            return -1;
        int value = stackData.pop();
        //当pop出的是当前的最小值，需从最小值栈里将该元素移除
        stackMin.pop();
        return value;
    }

    public int getMin(){
        if (!stackMin.isEmpty())
            return stackMin.peek();
        else
            return -1;
    }

}
