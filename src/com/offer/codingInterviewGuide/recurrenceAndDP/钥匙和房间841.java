package com.offer.codingInterviewGuide.recurrenceAndDP;

import javax.jnlp.ClipboardService;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/31 17:08
 * @Describe
 */

class DP14 {


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() <= 0 )
            return true;
        if(rooms.get(0) == null || (rooms.get(0).size() <= 0 && rooms.size() > 1)) // rooms.size()>1防止[[]]的情况
            return false;
        boolean[] flags = new boolean[rooms.size()];
        dfs(rooms,flags,0);
        for (boolean flag:flags)
            if(!flag)
                return false;
        return true;
    }

    private void dfs(List<List<Integer>> rooms,boolean[] flags, int roomNumber) {
        flags[roomNumber] = true;//表示能访问
        List<Integer> numbers = rooms.get(roomNumber);
        if(numbers != null){
            int temp = 0;
            for(int i = 0 ; i < numbers.size() ; i++){
                temp = numbers.get(i);
                if(temp >= 0 && temp < rooms.size() && !flags[temp]){
                    dfs(rooms,flags,temp);
                    numbers.set(i,rooms.size());//表示遍历过,防止重新进入,进入死循环
                }
            }
        }
    }
}
