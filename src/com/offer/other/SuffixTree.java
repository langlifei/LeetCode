package com.offer.other;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 使用前缀树来过滤敏感词汇
 * @Author: zz
 * @Date: 2022/6/23 16:23
 */
public class SuffixTree {

    private TreeNode rootNode;

    private static final String SENSITIVE_WORD_FLAG = "***";

    private int size;

    public SuffixTree(){
        this.rootNode = new TreeNode();
    }

    public SuffixTree(String words){
        this.rootNode = new TreeNode();
        addSensitiveWord(words);
    }


    /**
     * 增加敏感词
     * @param words 敏感词
     * @return 是否成功添加
     */
    public boolean addSensitiveWord(String words){
        if( words == null || words.length() <= 0){
            return false;
        }
        TreeNode tempNode = rootNode;
        char[] chars = words.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            //如果当前字符已经存在前缀树中,则将临时结点指向当前字符所表示结点
            if(tempNode.getSubNode(aChar) != null){
                tempNode = tempNode.getSubNode(aChar);
                continue;
            }
            //当前结点不在临时结点的子结点中,添加当前字符结点为其子节点
            TreeNode treeNode = new TreeNode(aChar);
            if( i == chars.length - 1){
                treeNode.isKeyWordsEnd = true;
            }
            //添加当前结点到临时结点的子结点中
            tempNode.addSubNode(aChar,treeNode);
            tempNode = treeNode;
            size++;
        }
        return true;
    }

    public String filter(String text){
        if(text == null || text.length() <= 0){
            return "";
        }
        char[] chars = text.toCharArray();
        int len = chars.length;
        //开始指针以及位置指针
        int begin = 0, position = 0;
        TreeNode tempNode = rootNode;
        while(position < len){
            char aChar = chars[position];
            TreeNode subNode = tempNode.getSubNode(aChar);
            if(subNode == null){
                position = begin;
                begin++;
            }else{
                if(subNode.isKeyWordsEnd){
                    //添加过滤字符
                    for(int i = begin; i<= position; i++){
                        chars[i] = '*';
                    }
                    begin = position + 1;
                    tempNode = rootNode;
                }else{
                    tempNode = subNode;
                }
            }
            position++;
        }
        return new String(chars);
    }


    private static class TreeNode{

        /**
         * 是否为叶子结点
         */
        private boolean isKeyWordsEnd = false;

        /**
         * 结点值
         */
        private Character value;

        /**
         * 存储子结点的集合
         */
        private Map<Character,TreeNode> subNodes = new HashMap<>();

        public TreeNode(){};


        public TreeNode(Character value){
            this.value = value;
        }

        public TreeNode(Character value , Boolean isKeyWordsEnd){
            this.value = value;
            this.isKeyWordsEnd = isKeyWordsEnd;
        }



        public void addSubNode(Character key,TreeNode node){
            subNodes.put(key,node);
        }

        public TreeNode getSubNode(Character key){
            return subNodes.get(key);
        }
    }

    public static void main(String[] args) {
        SuffixTree suffixTree = new SuffixTree();
        suffixTree.addSensitiveWord("王八羔子");
        suffixTree.addSensitiveWord("王八蛋");
        suffixTree.addSensitiveWord("大坏蛋");
        suffixTree.addSensitiveWord("大猪蹄子");
        suffixTree.addSensitiveWord("讨厌");
        suffixTree.addSensitiveWord("傻逼");
        suffixTree.addSensitiveWord("傻逼东西");
        suffixTree.addSensitiveWord("狗叫");
        System.out.println(suffixTree.filter("傻逼玩意,我草,王八蛋儿子,你在狗叫什么???"));
    }
}
