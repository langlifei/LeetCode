package com.offer.leetcode.medium;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @Author: zz
 * @Date: 2022/7/7 13:27
 */
class Solution648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        SuffixTree suffixTree = new SuffixTree();
        for (String s : dictionary) {
            suffixTree.add(s);
        }
        String[] split = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            result.append(suffixTree.replace(split[i]));
            result.append(" ");
        }
        return result.toString().length() > 0 ? result.substring(0,result.length() - 1) : "";
    }

    public static class SuffixTree{

        public TreeNode root;

        public SuffixTree(){
            root = new TreeNode();
        }

        public void add(String target){
            if( target == null  || target.length() <= 0){
                return ;
            }
            char[] chars = target.toCharArray();
            char c;
            TreeNode temp = root;
            for (int i = 0; i < chars.length; i++) {
                c = chars[i];
                Solution648.SuffixTree.TreeNode treeNode = temp.subTreeNode.get(c);
                if(treeNode == null){
                    treeNode = new Solution648.SuffixTree.TreeNode();
                    temp.subTreeNode.put(c,treeNode);
                    temp = treeNode;
                }else{
                    temp = treeNode;
                }
                if(i == chars.length - 1){
                    treeNode.isEndNode = true;
                }
            }
        }

        public String replace(String target){
            if(target == null || target.length() <= 0){
                return target;
            }
            char[] chars = target.toCharArray();
            TreeNode tempNode = root;
            char c;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                c = chars[i];
                TreeNode treeNode = tempNode.subTreeNode.get(c);
                if(treeNode == null){
                    return target;
                }else{
                    res.append(c);
                    tempNode = treeNode;
                    if(treeNode.isEndNode){
                        return res.toString();
                    }
                }
            }
            return target;
        }

        public static class TreeNode{
            /**
             * 是否尾结点
             */
            public boolean isEndNode;

            public Map<Character, Solution648.SuffixTree.TreeNode> subTreeNode = new HashMap<>();
        }

    }

    public static void main(String[] args) {
        Solution648 solution648 = new Solution648();
        ArrayList<String> tempList = new ArrayList<>();
        tempList.add("cat");
        tempList.add("bat");
        tempList.add("rat");
        solution648.replaceWords(tempList,"the cattle was rattled by the battery");
    }
}
