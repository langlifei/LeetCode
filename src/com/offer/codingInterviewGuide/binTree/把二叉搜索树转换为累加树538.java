package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;
class Tree09 {

    public TreeNode convertBST(TreeNode root) {
        if( root  == null )
            return null;
        int sum = sumTree(root.right);
        root.val += sum;
        convertBST(root.right);
        convertBST(root.left);
        sumLeftTree(root.left,root.val);
        return root;
    }

    public int sumTree(TreeNode root){
        if(root == null)
            return 0;
        if(root.left==null && root.right==null)
            return root.val;
        int left = sumTree(root.left);
        int right = sumTree(root.right);
        return left+right+root.val;
    }
    public void sumLeftTree(TreeNode root, int val){
        if(root == null)
            return ;
        root.val+=val;
        sumLeftTree(root.left,val);
        sumLeftTree(root.right,val);
    }
}
