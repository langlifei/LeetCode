package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/18 23:10
 * @Describe
 */

class Tree03 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tree = null;
        int size = 0;
        List<Integer> temp = null;
        while(!queue.isEmpty()){
            temp = new ArrayList<>();
            size = queue.size();
            for(int i = 0 ; i < size;i++){
                tree = queue.poll();
                if(tree.left!=null)
                    queue.add(tree.left);
                if(tree.right!=null)
                    queue.add(tree.right);
                temp.add(tree.val);
            }
            list.add(temp);
        }
        return list;
    }
}
