package com.offer.codingInterviewGuide.binTree.traverse.recur;

import com.offer.sword.TreeNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/21 6:55
 * @Describe
 */

public class PostOrder {

    public void postOrder(TreeNode tree){
        if(tree==null)
            return;
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.val);
    }
}
