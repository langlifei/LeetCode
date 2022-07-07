package com.offer.leetcode.medium;

import com.offer.sword.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zz
 * @Date: 2022/6/24 16:40
 */
class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> tempList = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            while(!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if(poll.val > max){
                    max = poll.val;
                }
                if(poll.left != null){
                    tempList.add(poll.left);
                }
                if(poll.right != null){
                    tempList.add(poll.right);
                }
            }
            result.add(max);
            queue.addAll(tempList);
            tempList.clear();
        }
        return result;
    }
}
