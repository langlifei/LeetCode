package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

class Tree14 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null || p == null || q == null)
            return null;
        if( p.val > q.val){
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        return find(root,p,q);
    }

    public TreeNode find(TreeNode root,TreeNode p , TreeNode q){
        if( root == null || p == null || q == null)
            return null;
        if(root.val < p.val)
            return find(root.right,p,q);
        if( root.val > q.val )
            return find(root.left,p,q);
        return root;
    }
}
