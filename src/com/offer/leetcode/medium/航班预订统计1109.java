package com.offer.leetcode.medium;

/**
 * @Description:
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * @Example:
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * @Solution: 使用差分数组,解决区间内加减问题,减少区间内需要修改的值.
 * @Author: zz
 * @Date: 2022/6/21 12:33
 */
class Solution1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            for(int i1 = bookings[i][0]; i1 <= bookings[i][1]; i1++){
                result[i1-1] = result[i1-1] + bookings[i][2];
            }
        }
        return result;
    }

    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            result[booking[0]-1] += booking[2];
            if(booking[1] < n){
                result[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] + result[i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1109().corpFlightBookings1(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5));
    }
}
