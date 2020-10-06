package com.offer.codingInterviewGuide.binTree;

import com.offer.sword.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tree11 {
    int max = 1;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        find(root,root.val);
        int[] array = new int[list.size()];
        for(int i = 0 ; i < array.length ; i++)
            array[i] = list.get(i);
        return array;
    }

    public int find(TreeNode root,int val){
        if( root==null )
            return 0;
        int left,right;
        int count = 0;
        boolean flag = false;
        if(root.val==val){
            count++;
            flag = true;
        }
        left = find(root.left,root.val);
        right = find(root.right,root.val);
        count+=(left+right);
        count+=flag?0:1;
        if(count>max){
            max = count;
            list.clear();
            list.add(root.val);
        }else if(count==max)
            list.add(root.val);
        return flag?count:0;
    }

    Map<Integer,Integer> map = new HashMap<>();

    public int[] findMode1(TreeNode root){
        if(root == null)
            return new int[0];
        traverse(root);
        int count = 1;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            count = entry.getValue();
            if(count>max){
                max = count;
                list.clear();
                list.add(entry.getKey());
            }else if(count==max)
                list.add(entry.getKey());
        }
        int[] array = new int[list.size()];
        for(int i = 0 ; i < array.length ; i++)
            array[i] = list.get(i);
        return array;
    }

    private void traverse(TreeNode root) {
        if(root==null)
            return ;
        if(map.containsKey(root.val))
            map.put(root.val,map.get(root.val)+1);
        else
            map.put(root.val,1);
        traverse(root.left);
        traverse(root.right);
    }
}
