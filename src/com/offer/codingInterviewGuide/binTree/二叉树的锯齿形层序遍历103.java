package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

import java.util.*;

/**
 * @Author Zeng Zhuo
 * @Date 2020/8/27 13:21
 * @Describe
 */

class Tree05 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> temp = null;
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();//记住当前层的个数
            temp = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                root = queue.poll();
                temp.add(root.val);
                if(root.left!=null)
                    queue.add(root.left);
                if(root.right!=null)
                    queue.add(root.right);
            }
            if( level % 2 == 0)
                Collections.reverse(temp);
            lists.add(temp);
            level++;
        }
        return lists;
    }
}
