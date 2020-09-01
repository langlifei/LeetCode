package com.offer.codingInterviewGuide.binTree.traverse.unRecur;

import com.offer.sword.TreeNode;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/21 7:02
 * @Describe
 */

public class InOrder {

    public void inOrder(TreeNode tree){
        if(tree==null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || tree != null){
            //先往左走，然后再往右走
            if(tree!=null){
                stack.push(tree);
                tree = tree.left;
            }else{
                tree = stack.pop();
                System.out.println(tree.val);
                tree = tree.right;
            }
        }
    }
}
