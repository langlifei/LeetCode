package com.offer.leetcode.medium;

/**
 * @Description:
 * 给你一个整数 num ，请你返回三个连续的整数，它们的 和 为 num 。如果 num 无法被表示成三个连续整数的和，请你返回一个 空 数组。
 * @Example:
 * 输入：num = 33
 * 输出：[10,11,12]
 * 解释：33 可以表示为 10 + 11 + 12 = 33 。
 * 10, 11, 12 是 3 个连续整数，所以返回 [10, 11, 12] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-three-consecutive-integers-that-sum-to-a-given-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zz
 * @Date: 2022/6/14 23:02
 */
class Solution2177 {

    public long[] sumOfThree(long num) {
        long[] result = new long[]{};
        long avg = num / 3;
        if(avg * 3 == num){
            result = new long[3];
            result[0] = avg - 1;
            result[1] = avg;
            result[2] = avg + 1;
        }
        return result;
    }
}
