package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Tree08 {

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if(root == null || (root.left==null&&root.right==null))
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> dirQueue = new LinkedList<>();
        queue.add(root);
        dirQueue.add(0);
        int dir = -1;
        boolean flag = false;
        while(!queue.isEmpty()){
            root = queue.poll();
            dir = dirQueue.poll();
            flag = true;
            if(root.left!=null){
                queue.add(root.left);
                dirQueue.add(1);
                flag = false;
            }
            if(root.right!=null){
                queue.add(root.right);
                dirQueue.add(2);
                flag = false;
            }
            if(flag&&dir==1)
                res+=root.val;
        }
        return res;
    }

}
