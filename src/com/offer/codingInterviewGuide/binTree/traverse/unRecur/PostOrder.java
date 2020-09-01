package com.offer.codingInterviewGuide.binTree.traverse.unRecur;

import com.offer.sword.TreeNode;

import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/21 22:31
 * @Describe
 */

public class PostOrder {

    //使用两个栈
    public void postOrder1(TreeNode tree){
        if(tree == null)
            return ;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(tree);
        while(!stack1.isEmpty()){
            tree = stack1.pop();
            stack2.push(tree);
            if(tree.left != null)
                stack1.push(tree.left);
            if(tree.right != null)
                stack1.push(tree.right);
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
        }
    }

    //使用一个栈，并记录最近访问的节点
    public void postOrder2(TreeNode tree){
        if(tree == null)
            return ;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        TreeNode c = null;
        while(!stack.isEmpty()){
            c = stack.peek();
            //有右子树，并且还没有遍历左右子树
            if(c.left != null && c.left != tree && c.right != tree)
                stack.push(c.left);
            else if(c.right != null && c.right != tree)
                stack.push(c.right);
            else {
                System.out.println(stack.pop().val);
                tree = c;
            }
        }
    }
}
