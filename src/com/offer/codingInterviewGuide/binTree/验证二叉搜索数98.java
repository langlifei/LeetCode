package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/22 22:52
 * @Describe
 */

class Tree04 {

    //检验是否为二叉树，不但左子数要为二叉搜索树，并且其整个左子树都需要小于它的上界，右子树同理。
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;
        int val = node.val;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;
        if (! helper(node.right, val, upper))
            return false;
        if (! helper(node.left, lower, val))
            return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {
        Tree04 test = new Tree04();
    }
}
