package com.offer.codingInterviewGuide.arrayAndMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/25 9:36
 * @Describe
 */

class Array04 {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();



    //使用深度优先搜素+剪枝通用模板
    public void dfs(int cur , int[] nums){
        //边界
        if(cur == nums.length){
            if(isValid()&&notVisited()){
                lists.add(new ArrayList<>(temp));
            }
            return ;
        }
        //选择当前元素的情况
        temp.add(nums[cur]);
        dfs(cur+1,nums);
        //对当前元素进行回退，返回到之前的状态
        temp.remove(nums[cur]);
        //查看不选择当前元素的情况
        dfs(cur+1,nums);
    }

    private boolean notVisited() {
        return true;
    }

    private boolean isValid() {
        return true;
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums == null || nums.length <= 1)
            return null;
        dfs(0,Integer.MIN_VALUE,nums);
        return lists;
    }

    //由于是寻找递增子序列，故用last保存最后一个元素的值
    private void dfs(int cur, int last, int[] nums) {
        //访问到最后一个元素
        if(nums.length == cur){
            //是否有效的依据是递增子序列的个数是否大于2
            if(temp.size() >= 2)
                lists.add(new ArrayList<>(temp));
            return;
        }
        //只有当最后一个值小于等于当前值时才选当前值
        if(nums[cur]>=last){
            //选择当前值
            temp.add(nums[cur]);
            dfs(cur+1,nums[cur],nums);
            //回退
            temp.remove(temp.size()-1);
        }
        /**
         * 由于如果两值相等，那么可能出现四种情况
         *         1.选前者，选后者
         *         2.选前者，不选后者
         *         3.不选前者，选后者
         *         4.不选前者，不选后者
         *  分析：
         *      1.如果程序没选前者，那么后者也不能选中，故不会出现第四种情况
         *      2.两者都选，其子序列并不重复，故两值相等，不会出现重复子序列
         *      3.只有当第二种情况和第三种情况同时发生时，会出现重复子序列，
         *        故在这两种情况中只选择一种即可。当当前值和最后一个值相等时，
         *        即表示子序列选着了前者，故可直接跳过后者，达到去重的目的。
         */
        if(nums[cur]!=last)
            dfs(cur+1,last,nums);
    }

    private void incrementSubSequences(Set<ArrayList<Integer>> set, int[] nums,int index) {
        if( index <= 0)
            return;
    }

    public static void main(String[] args) {
        Array04 test = new Array04();
        int[] nums = new int[]{4,6,7,7};
        System.out.println(test.findSubsequences(nums));
    }
}
