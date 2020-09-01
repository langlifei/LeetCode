package com.offer.sword;

import java.util.Stack;

/*
*                           时间:2020年3月5日15:41:27
*                           地点:湖北省仙桃市
*                           问题:用两个栈来实现一个队列，完成队列的Push和Pop操作.
*                                队列中的元素为int类型。
*                           通过率:100%
*
* */


public class Stack05 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //直接加入stack1
        stack1.push(node);
    }

    public int pop() {
        //从stack2取数据
        if(stack2.isEmpty()){
            if(stack1.isEmpty())
                return -1;//如果stack1为空,说明队列中没有数据,直接返回错误标志.
            //如果stack1不为空
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());//将stack1中全部倒置到stack2中,实现队列的先进先出.
            }
        }
        return stack2.pop();//取出stack2的栈顶数据
    }

    public static void main(String[] args){
        Stack05 s = new Stack05();
        for(int i = 0 ; i < 5; i++){
            s.push(i);
        }
        for(int i = 0 ; i < 5 ; i++){
            System.out.println(s.pop());
        }
    }

}
