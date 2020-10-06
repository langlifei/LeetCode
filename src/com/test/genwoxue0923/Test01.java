package com.test.genwoxue0923;

import java.util.*;

public class Test01 {

    static List<List<String>> mergeAccount(List<List<String>> accounts) {
        // 在此处编写实现代码逻辑
        if(accounts == null)
            return null;
        HashMap<String, Set<String>> map = new HashMap<>();
        String name = null;
        String email = null;
        List<String> list = null;
        Set<String> temp = null;
        for(int i = 0 ; i < accounts.size();i++){
            list = accounts.get(i);
            name = list.get(0);
            if(map.containsKey(name)){
                temp = map.get(name);
                for(int j = 1 ; j < list.size(); j++){
                    email = list.get(j);
                    if(temp.contains(email)){
                        int m = 1;
                        while(m<list.size()){
                            temp.add(list.get(m));
                            m++;
                        }
                        accounts.remove(i);//移除这条数据
                        break;
                    }
                }
            }else{
                HashSet<String> tempSet = new HashSet<>();
                int m = 1;
                while(m<tempSet.size()){
                    tempSet.add(list.get(m));
                    m++;
                }
                map.put(name, tempSet);
                accounts.remove(i);
            }
        }
        Set<String> keys = map.keySet();
        for(String str : keys){
            List<String> strings = new ArrayList<>();
            strings.add(str);
            Set<String> stringSet = map.get(str);
            for (String s:stringSet) {
                strings.add(s);
            }
            accounts.add(strings);
        }
        return accounts;
    }
}
