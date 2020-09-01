package com.offer.codingInterviewGuide.stackAndQueue;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/1 14:22
 * @Describe
 */

class stack04 {

    private Stack<Integer> stack;

    public stack04() {
        this.stack = new Stack<>();
    }

    public static void sortStackByStack(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        Stack<Integer> help = new Stack<>();
        int value = 0;
        while(!stack.isEmpty()){
            value = stack.pop();
            while(!help.isEmpty()&&value>help.peek())
                stack.push(help.pop());
            help.push(value);
        }
        //将help中的升序压回stack形成降序
        while(!help.isEmpty());
            stack.push(help.peek());
    }
}
