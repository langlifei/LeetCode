package com.offer.leetcode.sword.easy;

import com.offer.sword.TreeNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/12 15:19
 * @Describe
 */

public class 二叉树的镜像27 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root==null)
            return null;
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root;
    }
}
