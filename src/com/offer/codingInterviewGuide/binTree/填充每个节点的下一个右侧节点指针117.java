package com.offer.codingInterviewGuide.binTree;


import java.util.LinkedList;
import java.util.Queue;

class Tree15 {

    public Node connect(Node root) {
        if( root == null )
            return null;
        Queue<Node> queue = new LinkedList<>();
        Node myRoot = root;
        int size = 0;
        Node pre = root;
        queue.add(root);
        while(!queue.isEmpty()){
            pre = queue.peek();
            size = queue.size();
            while( size > 0 ){
                root = queue.poll();
                if(pre != root)
                    pre.next = root;
                if( root.left != null )
                    queue.add(root.left);
                if( root.right != null)
                    queue.add(root.right);
                pre = root;
                size--;
            }
            pre.next = null;
        }
        return myRoot;
    }
}
