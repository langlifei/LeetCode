package com.test.tongcheng0921;

import java.util.ArrayList;

public class Test03 {


    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        if(arrayA == null || arrayB == null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0 ;
        int j = 0;
        while( i < arrayA.size() && j < arrayB.size() ){
            if(arrayA.get(i) < arrayB.get(j))
                i++;
            else if(arrayA.get(i)>arrayB.get(j))
                j++;
            else{
                list.add(arrayA.get(i));
                i++;
                j++;
            }
        }
        return list;
    }
}
