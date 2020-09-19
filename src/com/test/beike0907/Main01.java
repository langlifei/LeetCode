package com.test.beike0907;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main01 {

    public static Map<String,String> map = new HashMap<>();

    public String f(String[] strings){
        if(strings == null || strings.length<4)
            return "error";
        int leftRate = 0 , rightRate = 0;
        String left = strings[0],right = strings[1];
        if(map.get(left)!=null&&map.get(left).equals(strings[2]))
            leftRate++;
        else
            leftRate--;
        if(map.get(left)!=null&&map.get(left).equals(strings[3]))
            leftRate++;
        else
            leftRate--;
        if(map.get(right)!=null&&map.get(right).equals(strings[2]))
            rightRate++;
        else
            rightRate--;
        if(map.get(right)!=null&&map.get(right).equals(strings[3]))
            rightRate++;
        else
            rightRate--;
        if(rightRate>leftRate)
            return "right";
        else if(rightRate<leftRate)
            return "left";
        else
            return "same";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Main01 test01 = new Main01();
        map.put("S","J");
        map.put("J","B");
        map.put("B","S");
        for(int i = 0 ; i < n ; i++)
            System.out.println(test01.f(in.nextLine().split(" ")));
    }
}
