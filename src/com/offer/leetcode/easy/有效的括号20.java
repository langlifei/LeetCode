package com.offer.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/30 18:09
 * @Describe
 */

public class 有效的括号20 {

    private Stack<Character> stack = new Stack<>();
    private static Map<Character,Character> map = new HashMap<>();

    static {
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
    }

    public boolean isValid(String s) {
        char c = ' ';
        for(int i = 0 ; i < s.length();i++){
            c = s.charAt(i);
            if(c == '('||c=='{'||c=='[')
                stack.push(c);
            else{
                if(c==map.get(stack.peek())){
                    stack.pop();
                }else
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
