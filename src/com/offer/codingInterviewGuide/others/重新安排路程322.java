package com.offer.codingInterviewGuide.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/27 9:15
 * @Describe
 */

class Others07 {


    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets == null)
            return null;
        HashMap<String,List<String>> map = new HashMap<>();
        List<String> temp = null;
        //归类
        for(List<String> list:tickets){
            if(map.containsKey(list.get(0)))
                map.get(list.get(0)).add(list.get(1));
            else {
                temp = new ArrayList<>();
                temp.add(list.get(1));
                map.put(list.get(0),temp);
            }
        }
        //对字典排序
        for(String str:map.keySet()){
            temp = map.get(str);
            temp.sort((s1,s2)->(s1.compareTo(s2)));
        }
        //路程选择
        List<String> path = new ArrayList<>();
        path.add("JFK");
        while(true){
            String key = path.get(path.size()-1);
            List<String> tempList = map.get(key);
            if(tempList!=null && tempList.size() != 0){
                path.add(tempList.get(0));
                tempList.remove(0);
            }else
                return path;
        }
    }
}
