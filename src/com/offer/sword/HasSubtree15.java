package com.offer.sword;

/*
*                               时间:2020年3月8日15:18:53
*                               地点:湖北省仙桃市
*                               问题:输入两棵二叉树A，B，判断B是不是A的子结构。
*                                   （ps：我们约定空树不是任意一个树的子结构
*                               结果:通过;
*                               注:递归的思想,从小推到大.
* */

public class HasSubtree15 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        if(root1==null || root2 == null)
            return false;
        if(equal(root1,root2))
            return true;
        else
            return equal(root1.left,root2)||equal(root1.right,root2);
    }

    public boolean equal(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        else if(root1==null)
            return false;
        else if(root2==null)
            return true;
        if(root1.val!=root2.val)
            return false;
        return equal(root1.left,root2.left)&&equal(root1.right,root2.right);
    }
}
