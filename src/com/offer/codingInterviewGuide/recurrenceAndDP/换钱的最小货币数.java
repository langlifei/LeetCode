package com.offer.codingInterviewGuide.recurrenceAndDP;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/9 9:59
 * @Describe
 */

class DP04 {


    //允许重复使用arr中的值
    public int minCoins1(int[] arr,int aim){
        if(aim < 0 || arr==null || arr.length == 0)
            return -1;
        if(aim == 0)
            return 0;
        int[] dp = new int[aim+1];
        int max = Integer.MAX_VALUE;
        dp[0] = 0;//数组初始化为0,可删掉
        //初始化dp
        for(int i = 1 ; i <= aim; i ++){
            dp[i] = max;
            //当i-arr[0]>=0表明可采用最少一张面值为arr[0]的钞票
            //dp[i-arr[0]] != max含义为
            // 如果条件成立,表明i可由不止一张arr[0]的面值表示,dp数组之前已经存有了当时的i可由arr[0]表示的张数,
            // 可减少重复计算,依赖之前的值
            // 如果条件不成立,表明当前i的面值 i  % arr[0] != 0,即金额i不能由整数张面值为arr[0]来表示
            if( i - arr[0] >= 0 && dp[i-arr[0]] != max)
                dp[i] = dp[i-arr[0]]+1;
        }
        //滚动更新dp数组
        for(int i = 1 ; i< arr.length; i++){
            for(int j = 1 ; j < dp.length; j++)
                if( j - arr[i] >= 0 && dp[j - arr[i]] != max)
                    //在arr[i-1]能表示i的张数和arr[j-arr[i]]+1能表示j的张数中选一个小值
                    //可采用空间压缩是因为当前dp[j]在没更新前存储的还是arr[i-1]能表示i的张数,
                    //而dp[j-arr[i]]已经被更新了,存储的是当前面值arr[i]能表示钱数为j-arr[i]的张数
                    dp[j] =  Math.min(dp[j],dp[j-arr[i]]+1);
        }
        return dp[aim]!=max?dp[aim]:-1;
    }

    //不允许重复使用arr中的值
    public int minCoins2(int[] arr,int aim){
        if(aim < 0 || arr==null || arr.length == 0)
            return -1;
        if(aim == 0)
            return 0;
        int[] dp = new int[aim+1];
        int max = Integer.MAX_VALUE;
        dp[0] = 0;//数组初始化为0,可删掉
        //初始化dp
        for(int i = 1; i < dp.length;i++)
            dp[i] = max;
        if(arr[0]<=aim)
            dp[arr[0]] = 1;
        //滚动更新dp数组
        for(int i = 1 ; i< arr.length; i++){
            for(int j = aim ; j >0 ; j--) // 每行从右往左更新,避免重复使用当前arr[i]
                if( j - arr[i] >= 0 && dp[j - arr[i]] != max)
                    //在arr[i-1]能表示i的张数和arr[j-arr[i]]+1能表示j的张数中选一个小值
                    //可采用空间压缩是因为当前dp[j]在没更新前存储的还是arr[i-1]能表示i的张数,
                    //而dp[j-arr[i]]已经被更新了,存储的是当前面值arr[i]能表示钱数为j-arr[i]的张数
                    dp[j] =  Math.min(dp[j],dp[j-arr[i]]+1);
        }
        return dp[aim]!=max?dp[aim]:-1;
    }

    public static void main(String[] args) {
        DP04 test = new DP04();
        int[] arr = {5,2,5,3};
        System.out.println("换钱的最小货币数"+test.minCoins1(arr, 15));
        System.out.println("换钱的最小货币数"+test.minCoins2(arr, 15));
    }
}
