package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Tree13 {
    private List<List<Integer>> lists = null;
    private List<Integer> list = null;
    private int res = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists =  new ArrayList<>();
        if (root == null)
            return lists;
        list = new ArrayList<>();
        path(root, sum);
        return lists;
    }

    private void path(TreeNode root, int sum)   {
        if(root.left==null&&root.right==null){
            if(res+root.val==sum){
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        res += root.val;
        if(root.left != null)
            path(root.left,sum);
        if(root.right != null)
            path(root.right,sum);
        list.remove(list.size()-1);
        res -= root.val;
    }
}
