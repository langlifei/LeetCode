package com.offer.sword;

/*
                        时间:2020年3月9日12:53:49
                        地点:湖北省仙桃市
                        问题:定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
                             注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法
                        结果:通过
 */

import java.util.Stack;

public class Stack20 {

    Stack<Integer> stack = new Stack<>();
    int min = 0;
    public void push(int node) {
        if(node<min)
            min = node;
        stack.push(node);
    }

    public void pop() {
        if(stack.peek()!=min){
            stack.pop();
        }else{
            stack.pop();
            if(!stack.isEmpty())
                min = stack.peek();
            Stack<Integer> temp = new Stack<>();
            while(!stack.isEmpty()){
                if(stack.peek()<min)
                    min = stack.peek();
                temp.push(stack.pop());
            }
            while(!temp.isEmpty())
                stack.push(temp.pop());
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
