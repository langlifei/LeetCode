package com.offer.sword;

/**
 *                          时间:2020年3月4日12:03:06
 *                          地点:湖北省仙桃市
 *                          问题:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *                              假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 *                              和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 *                          通过率:100%
 *                          运行时间:297ms
 *                          运行内存:26488k;
 *                          不足:内存资源消耗比较大.
 *
 */

public class BinTree04 {

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }else{
            TreeNode t = new TreeNode(pre[0]);
            int l = 0 ; //记录左节点的个数
            int r = 0;  //记录右节点的个数
            boolean flag = false;//标志是当前值的下标是否超过根节点
            for(int i = 0 ; i < in.length; i++){
                if(!flag&&in[i] != pre[0]){
                    l++;
                }else if(flag){
                    r++;
                }else{
                    flag = true;//表示之后的节点为右节点
                }
            }
            //筛出左右子树的先序数组
            int [] lp = new int[l]; // 存储左子树先序
            int [] rp = new int[r]; // 存储右子树先序
            for(int i = 1; i < pre.length;i++){
                if(i-1 < l){
                    lp[i-1] = pre[i];
                }else if( i - l <= r){
                    rp[i-l-1] = pre[i];
                }
            }
            //对中序遍历的左右子树进行分别存储.
            int[] lI = new int[l];
            int[] rI = new int[r];
            flag = false;//重置标记
            for(int i = 0 ; i < in.length; i++){
                if(!flag&&in[i] != pre[0]){
                    lI[i] = in[i];
                }else if(flag){
                    rI[i-l-1] = in[i];
                }else{
                    flag = true;//表示之后的节点为右节点
                }
            }
            //设置左子树;
            t.left = reConstructBinaryTree(lp,lI);
            //设置右子树;
            t.right = reConstructBinaryTree(rp,rI);
            return t;
        }
    }

    public static void main(String[] args){
        BinTree04 b = new BinTree04();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode t = b.reConstructBinaryTree(pre,in);
        System.out.println(t);
    }
}
