package com.offer.sword;

public class FindMinLengthOfN {

    /**
     *
     * 解题思路：1.在N%L==0且L为奇数时才有数列和。如：（... m-3,m-2,m-1,m,m+1,m+2,m+3 ...）
     *          2.在N%L!=0且L为偶数时才有数列和，且数列和为(...m-3,m-2,m-1,m,m+1,m+2,m+3,m+k，若k=4，k为N%L的余数)，
     *            即由等差数列公式将其转换为（2*m+1）*L/2=N。
     *          3.其余两种情况都不可能产生数列和，故采用递归调用并对其L+1；
     * @result(39ms,10508k)
     * @param N
     * @param L
     * @return
     */
    public String find(long N, int L){
        //违反一个就返回No
        if(N<1 || N>1000000000 || L< 2 || L > 100)
            return "No";
        int m = (int)(N/L);//除数
        int k = (int)(N%L);//余数
        //如果N/L能整除且长度为奇数
        if(k == 0&&L%2!=0){
           return f(m,L/2);
        }else if(k!=0&&L%2==0){//如果N/L不能整除且长度为偶数
            int s = (2*m+1)*L/2;//等差数列公式
            //s大于和小于N都有可能存在数列和。
            if(s == N)
                return f(m,(L-1)/2)+" "+(m+k);
            else
                return find(N,L+1);
        }else{
           return find(N,L+1);
        }
    }

    public String f(int m,int L){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = -L; i <=L; i++)
            stringBuffer.append((m+i)+" ");
        return stringBuffer.toString().trim();
    }

    public static void main(String... args){
        FindMinLengthOfN f = new FindMinLengthOfN();
        System.out.println(f.find(104950,26));
      }
}
