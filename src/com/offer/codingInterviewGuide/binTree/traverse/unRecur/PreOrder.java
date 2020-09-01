package com.offer.codingInterviewGuide.binTree.traverse.unRecur;

import com.offer.sword.TreeNode;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/21 6:56
 * @Describe
 */

public class PreOrder {

    public void preOrder(TreeNode tree){
        if(tree==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        TreeNode p = null;
        while(!stack.isEmpty()){
            p = stack.pop();
            System.out.println(p.val);
            if(p.right!=null)
                stack.push(p.right);
            if(p.left!=null)
                stack.push(p.left);
        }
    }
}
