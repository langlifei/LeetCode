package com.offer.leetcode.sword.easy;

import com.offer.sword.TreeNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/12 22:25
 * @Describe
 */

public class 对称的二叉树28 {

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return recur(root.left,root.right);
    }

    public boolean recur(TreeNode r1, TreeNode r2){
        if((r1==null||r2==null)&&r1!=r2)
            return false;
        if(r1 == null)
            return true;
        if(r1.val != r2.val)
            return false;
        return recur(r1.left,r2.right)&&recur(r1.right,r2.left);
    }
}
