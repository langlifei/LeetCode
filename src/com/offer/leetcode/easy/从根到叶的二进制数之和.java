package com.offer.leetcode.easy;

/**
 * @Author: zz
 * @Date: 2022/7/7 14:34
 */
class Solution1022 {

    public int sumRootToLeaf(TreeNode root) {
        return sum(root,root.val);
    }

    private int sum(TreeNode root, int val) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return val;
        }
        int sum = val * 2;
        int left = root.left == null ? 0 : sum(root.left,sum + root.left.val);
        int right = root.right == null ? 0 : sum(root.right, sum + root.right.val);
        return left + right;
    }


    public static class TreeNode{
        public TreeNode left;

        public TreeNode right;

        public int val;

    }
}
