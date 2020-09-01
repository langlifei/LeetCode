package com.offer.codingInterviewGuide.binTree.traverse.recur;

import com.offer.sword.TreeNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/21 6:53
 * @Describe
 */

public class InOrder {

    public void inOrder(TreeNode tree){
        if(tree==null)
            return;
        inOrder(tree.left);
        System.out.println(tree.val);
        inOrder(tree.right);
    }
}
