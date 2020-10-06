package com.test.tongcheng0921;

import com.offer.Sorts.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test01 {


    public int calculate (String input) {
        if(input == null || input.length() <= 0 )
            return 0;
        // write code here
        Map<Character,Integer> map = new HashMap<>();
        //去掉空格
        input = input.replaceAll(" ","");
        //设置优先级
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> codes = new Stack<>();
        char[] chars = input.toCharArray();
        char c = ' ';
        boolean flag = false;
        int nums = 0;
        int j = 0;
        for(int i = 0 ; i < chars.length ; i++){
            c = chars[i];
            if(map.containsKey(c)){
                //负号
                if( c == '-' ){
                    if(i==0)
                        flag = true;
                    else if( map.containsKey(chars[i-1]))
                        flag = true;
                    else
                        flag = false;
                }
                if(flag && c == '-')
                    continue;
                //存储操作数
                nums = Integer.parseInt(input.substring(j,i));
                j = i+1;
                nums = flag?-nums:nums;
                if(flag)
                    flag = false;
                numbers.push(nums);
                while(!codes.isEmpty()&&map.get(chars[i])<=map.get(codes.peek())){
                    int nums2 = numbers.pop();
                    int nums1 = numbers.pop();
                    numbers.push(f(nums1,nums2,codes.pop()));
                }
                codes.push(chars[i]);
            }
        }
        numbers.push(Integer.parseInt(input.substring(j,input.length())));
        while(!codes.isEmpty()){
            Character c1 = codes.pop();
            int nums2 = numbers.pop();
            int nums1 = numbers.pop();
            numbers.push(f(nums1,nums2,c1));
        }
        return numbers.isEmpty()?Integer.parseInt(input):numbers.peek();
    }

    public int f(int num1 , int num2 , char op){
        switch (op){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                return num1/num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.calculate("-10*4--12"));
    }
}
