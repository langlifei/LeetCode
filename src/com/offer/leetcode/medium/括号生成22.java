package com.offer.leetcode.medium;

import com.offer.sword.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zeng Zhuo
 * @Date 2020/5/30 22:05
 * @Describe key: 当数字的深度无法确定时，使用计算机的特有思想：递归。
 *               回溯法
 *               1.回退时删除添加的数
 *               2.找到递推的关系
 */

public class 括号生成22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list,new StringBuilder(),0,0,n);
        return list;
    }

    private void backTrack(List<String> list, StringBuilder str, int open, int close, int n) {
        if(str.length()==2*n){
            list.add(str.toString());
            return;
        }

        if(open<n){
            str.append('(');
            backTrack(list,str,open+1,close,n);
            str.deleteCharAt(str.length()-1);
        }

        if(close<open){
            str.append(')');
            backTrack(list,str,open,close+1,n);
            str.deleteCharAt(str.length()-1);
        }
    }

}
