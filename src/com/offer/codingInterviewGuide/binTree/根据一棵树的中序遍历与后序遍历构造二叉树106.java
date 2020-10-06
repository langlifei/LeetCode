package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

class Tree12 {
    Map<Integer,Integer> inOrderMap = new HashMap<>();
    int[] inorder = null;
    int[] postorder = null;
    int postIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length <= 0 || postorder == null || postorder.length <= 0)
            return null;
        for(int i = 0 ; i < inorder.length ; i++)
            inOrderMap.put(inorder[i],i);
        this.inorder = inorder;
        this.postorder = postorder;
        this.postIndex = postorder.length-1;
        return createBinTree(0,postorder.length-1);
    }

    private TreeNode createBinTree(int inLeft , int inRight) {
        if(inLeft > inRight)
            return null;
        TreeNode node = new TreeNode(postorder[postIndex--]);
        int index = inOrderMap.get(node.val);
        node.right = createBinTree(index+1,inRight);
        node.left = createBinTree(inLeft,index-1);
        return node;
    }
}
