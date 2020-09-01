package com.offer.sword;

/*
                        时间:2020年3月9日09:53:29
                        地点:湖北省仙桃市
                        问题:操作给定的二叉树，将其变换为源二叉树的镜像
                        结果:通过
                        注:不要忘记使用临时节点进行临时存储.

 */
public class Mirror18 {
    public void Mirror(TreeNode root) {
        root = swap(root);
    }

    public TreeNode swap(TreeNode root){
        if(root==null)
            return null;
        TreeNode temp = root.left;
        root.left = swap(root.right);
        root.right = swap(temp);
        return root;
    }
}
