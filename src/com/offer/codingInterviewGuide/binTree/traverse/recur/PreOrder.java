package com.offer.codingInterviewGuide.binTree.traverse.recur;

import com.offer.sword.TreeNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/21 6:51
 * @Describe
 */

public class PreOrder {

    public void preOrder(TreeNode tree){
        if(tree==null)
            return;
        System.out.println(tree.val);
        preOrder(tree.left);
        preOrder(tree.right);
    }
}
