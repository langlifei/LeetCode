package com.offer.leetcode.easy;

/**
 *
 * @Description:
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 *
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 *
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 *
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/height-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Example:
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/height-checker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zz
 * @Date: 2022/6/13 20:10
 */
class Solution1051 {
    public int heightChecker(int[] heights) {
        //采用计数排序
        int max = heights[0];
        //获取数组最大的元素值，开辟空间
        for (int i = 0; i < heights.length; i++) {
            if( heights[i] > max){
                max = heights[i];
            }
        }
        int[] expected = new int[max];
        //将目标数组在临时数组中进行值映射
        for (int height : heights) {
            expected[height-1]++;
        }
        //计算不符合排序坐标的数字
        int res = 0;
        int temp = 0;
        for (int i = 0 ; i < heights.length; i++) {
            temp = 0;
            for (int j = 0; j < heights[i] - 1; j++) {
                temp += expected[j];
            }
            //计算值是否在它实际排序后的下标范围内
            if(i + 1 > temp && i + 1 <= temp + expected[heights[i] - 1]){
                res++;
            }
        }
        //通过总长度-符合对应位置的数=不符合对应位置的数
        return heights.length - res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1051().heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }

}
