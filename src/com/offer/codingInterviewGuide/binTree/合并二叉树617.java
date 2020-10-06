package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

class Tree10 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null)
            return null;
        TreeNode t3;
        if( t1 != null )
            t3 = new TreeNode(t1.val);
        else
            t3 = new TreeNode(t2.val);
        if(t1!=null && t2!=null){
            t3.val = t1.val+t2.val;
        }
        t3.left = mergeTrees(t1==null?null:t1.left,t2==null?null:t2.left);
        t3.right = mergeTrees(t1==null?null:t1.right,t2==null?null:t2.right);
        return t3;
    }

    public static void main(String[] args) {

    }
}
