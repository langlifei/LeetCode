package com.offer.leetcode.sword.medium;

import com.offer.sword.TreeNode;

/**
 * @Author Zeng Zhuo
 * @Date 2020/6/7 13:07
 * @Describe 在中序列表中其左子树所需先序列表的长度,使用下标逐步缩小先序和中序的范围。
 */

public class 重建二叉树07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int pLow,int pHigh,int[] inorder, int iLow, int iHigh) {
        if(pLow>pHigh||iLow>iHigh)
            return null;
        int index = findX(inorder,iLow,iHigh,preorder[pLow]);
        if(index == -1)
            return null;
        TreeNode t = new TreeNode(preorder[pLow]);
        t.left = build(preorder,pLow+1,pLow+index-iLow,inorder,iLow,index-1);//index-iLow 为左子树在先序列表中的长度
        t.right = build(preorder,pLow+index-iLow+1,pHigh,inorder,index+1,iHigh);
        return t;
    }

    public int findX(int[] inorder,int low , int high ,int x){
        for(int i = low ; i<=high;i++)
            if(inorder[i] == x)
                return i;
        return -1;
    }
}
