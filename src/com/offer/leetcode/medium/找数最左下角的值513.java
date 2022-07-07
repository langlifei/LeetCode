package com.offer.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zz
 * @Date 2022/6/22 12:54
 * @Describe
 */
class Solution513 {

    Queue<TreeNode> queue = new LinkedList<>();

    public int findBottomLeftValue(TreeNode root) {
        Integer left = null;
        Integer right = null;
        queue.add(root);
        int result = 0;
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.right != null){
                queue.add(poll.right);
            }
            if(poll.left != null){
                queue.add(poll.left);
            }
            result = poll.val;
        }

        return result;
    }
    
  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
