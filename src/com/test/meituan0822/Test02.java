package com.test.meituan0822;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/22 16:39
 * @Describe
 */

class Main02 {

    public static int[] f(String str){
        int index = 0;
        for(int i = 0 ; i<str.length();i++)
            if(str.charAt(i) == ' '){
                index = i;
                break;
            }
        int n = Integer.parseInt(str.substring(0,index));
        int m = Integer.parseInt(str.substring(index+1));
        return new int[]{n,m};
    }

    public int[] test(int[][] data,int m){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = data.length-1; i >= 0 ;i--)
            map.put(data[i][0]+data[i][1]*2,i+1);
        int[] len = new int[data.length+1];
        int max = 0;
        for(int i = 0 ; i < m ; i++){
            for (Integer key:map.keySet())
                if(max < key)
                    max = key;
            len[map.get(max)] = 1;
            map.remove(max);
            max = 0;
        }
        int[] res = new int[m];
        int index = 0;
        for(int i = 1 ; i < len.length; i++)
            if(len[i]==1)
                res[index++] = i;
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nAndm = sc.nextLine();
        int[] nm = f(nAndm);
        String temp = "";
        int[][] data = new int[nm[0]][2];
        for (int i = 0 ; i < nm[0] ; i++){
            temp = sc.nextLine();
            data[i] = f(temp);
        }
        Main02 test = new Main02();
        int[] res = test.test(data,nm[1]);
        for(int i = 0 ; i < res.length ; i++)
            System.out.print(res[i]+" ");
    }
}
