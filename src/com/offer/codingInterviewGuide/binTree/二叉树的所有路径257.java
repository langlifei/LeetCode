package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Tree06 {

    List<String> lists = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if( root == null )
            return lists;
        String path = String.valueOf(root.val);
        traverse(root,path);
        return lists;
    }

    private void traverse(TreeNode root,String path) {
        if(root.left != null)
            traverse(root.left,path + "->"+root.left.val);
        if(root.right != null)
            traverse(root.right,path+ "->"+root.right.val);
        if(root.left==null && root.right==null)
            lists.add(path);
    }
}
