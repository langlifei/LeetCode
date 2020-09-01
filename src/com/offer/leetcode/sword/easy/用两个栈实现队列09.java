package com.offer.leetcode.sword.easy;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/6 16:00
 * @Describe
 */

public class 用两个栈实现队列09 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            if(stack2.empty())
                return -1;
        }
        return stack2.pop();
    }
}
