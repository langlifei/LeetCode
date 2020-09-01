package com.offer.sword;


/*
*                           时间:2020年3月6日17:49:53
*                           地点:湖北省仙桃市
*                           问题:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示.
*                           结果:通不过.
*                           原因:在线编辑器识别不了栈.
* */
import java.util.Stack;

public class NumberOf1_10 {

    public int NumberOf1(int n){
        if(n == 0)
            return 0;
        //当n为正数
        if(n > 0)
            return getCount(getPriCode(n),1);
        else{
            /*
            * 由于符号取补码,
            * 符号的补码为: 1. 求出负数绝对值的原码
                           2. 从原码的最后一位数码位往前数，当遇到第一个1时停在此位置
                           3. 将第一个1前面的数码全部求反
            * */
            Stack s = getPriCode(-n);
            Stack s1 = new Stack();
            //将二进制数反转.
            while(!s.isEmpty()){
                s1.push(s.pop());
            }
            //一直到pop到1个1为置.
            while(!s1.isEmpty()&&!s1.pop().equals(1));
            return getCount(s1,0)+1+1;//两个1分别为刚才弹出的一个,另一个是符号位.
        }
    }

    //获取该数值的二进制
    public Stack getPriCode(int n){
        Stack s = new Stack();
        while(n != 1){
            if(n % 2 == 0){
                s.push(0);
            }else
                s.push(1);
            n /= 2;
        }
        s.push(1);
        return s;
    }

    public int getCount(Stack s,int x){
        int count = 0;
        while(!s.isEmpty()){
            if(s.pop().equals(x))
                count++;
        }
        return count;
    }


    /*
    *    解法2:
    *          使用逻辑与运算来判断1的个数
    *          思想:每次对n-1进行与运算,每比一次就相当于是少了一个1
    *          原因:如果一个数的二进制最右边的1在第k位上,n-1的二进制可保证k左边的二进制数不变,第k位上的0变为1,k右边的0变为1
    *               (如果k右边有数的话),进行逻辑与运算后,k(包括k)右边的数都为0,那么就相当与判断出了一个1,之后循环进行下去,直到为0;
    *               最后逻辑与的次数就相当于1的个数
    * */
    public int NumberOf1_1(int n) {
        int count = 0;
        while (n!=0)
        {
            ++ count;
            n = (n - 1) & n;
        }
        return count;
    }



    public static void main(String[] args){
        NumberOf1_10 f = new NumberOf1_10();
        System.out.println("------"+f.NumberOf1(-80));
    }
}
