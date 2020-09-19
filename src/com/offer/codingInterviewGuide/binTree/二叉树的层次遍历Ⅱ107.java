package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Tree07 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        List<Integer> temp = null;
        while(!queue.isEmpty()){
            size = queue.size();
            temp = new ArrayList<>();
            for(int i = 0 ; i < size; i++){
                root = queue.poll();
                if(root.left!=null)
                    queue.add(root.left);
                if(root.right!=null)
                    queue.add(root.right);
                temp.add(root.val);
            }
            lists.add(0,temp);
        }
        return lists;
    }
}
