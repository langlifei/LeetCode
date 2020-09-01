package com.offer.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *                      时间:2020年4月13日10:31:31
 *                      地点:湖北省仙桃市
 *                      题解:1.第一行和最后一行方向才会反转
 *                           2.利用当前行来获取数据
 */

public class Z字形变换06 {

    public String convert(String s, int numRows){
        if(s.length()<=numRows||numRows==1)
            return s;
        List<StringBuffer> list= new ArrayList<>();
        //是否下行的标志
        boolean goingDown = false;
        //设置当前行
        int cur = 0;
        //对数组进行初始化
        for (int i = 0 ; i < numRows;i++)
            list.add(new StringBuffer());
        for (int i = 0 ; i<s.length();i++){
            list.get(cur).append(s.charAt(i));
            if(cur==0||cur==numRows-1)//当第一行和最后一行时改变方向
                goingDown=!goingDown;
            cur += goingDown?+1:-1;//改变当前行
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (StringBuffer str:list) {
            stringBuffer.append(str.toString());
        }
        return stringBuffer.toString();
    }
}
