package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/22 20:34
 * @Describe
 */

class Tree01 {


    public int findLongestPath(TreeNode tree, int sum){
        if(tree == null)
            return 0;
        int left = findLongestPath(tree.left,sum-tree.val);
        int right = findLongestPath(tree.right,sum-tree.val);
        //取两者里面最大的
        left = left>=right?left:right;
        if(left > 0)
            return left+1;
        if(tree.val - sum == 0 )
            return 1;
        else
            return 0;
    }
}
