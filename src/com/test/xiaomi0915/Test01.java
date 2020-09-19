package com.test.xiaomi0915;

import java.util.*;

public class Test01 {

    static Map<Character,Character> map = new HashMap<>();

    public boolean f(String str){
        Stack<Character> stack = new Stack<>();
        if(str==null || str.length()<=0)
            return true;
        int i = 0;
        char[] chars = str.toCharArray();
        char c = ' ';
        stack.push(chars[i++]);
        while(i < chars.length){
            c = chars[i++];
            if(map.containsKey(c)){
                if(!stack.isEmpty()){
                    if(stack.peek()==map.get(c)){
                        stack.pop();
                        continue;
                    }else
                        return false;
                }
            }
            stack.push(c);
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Scanner sc = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        while(sc.hasNextLine()){
            strings.add(sc.nextLine());
        }
        for(String str:strings)
            System.out.println(test01.f(str));
    }
}
