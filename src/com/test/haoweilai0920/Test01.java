package com.test.haoweilai0920;

import com.offer.sword.TreeNode;

import java.util.Stack;

public class Test01 {


    public String notReCuPreOrder (TreeNode root) {
        String res = "";
        // write code here
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res += (root.val+",");
            if(root.right!=null)
                stack.push(root.right);
            if(root.left!=null)
                stack.push(root.left);
        }
        return res.substring(0,res.length()-1);
    }
}
