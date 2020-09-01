package com.offer.codingInterviewGuide.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Zeng Zhuo
 * @Date 2020/7/3 16:33
 * @Describe
 */

public class  HfmTree{

    private Scanner sc = new Scanner(System.in);
    private final Integer T = 0;//表示当节点的id==T时,表明当前节点是合成节点
    private Tree root = null;
    private Integer N = 0;//营地个数

    private int getPositiveNum(String str){
        int key = 0;
        while(true){
            try {
                key= Integer.parseInt(sc.nextLine());
                if(key>=0)
                    break;
                else
                    System.out.print("必须输入大于0的数:");
            }catch (Exception e){
                System.out.print(str);
            }
        }
        return key;
    }

    private int getPositiveNum(){
        int key = 0;
        while(true){
            try {
                key= Integer.parseInt(sc.nextLine());
                if(key>=0)
                    break;
                else
                    System.out.print("必须输入大于0的数:");
            }catch (Exception e){
                System.out.print("输入的数必须为整数.");
            }
        }
        return key;
    }

    private int getNumber(){
        int key = 0;
        while(true){
            try {
                key= Integer.parseInt(sc.nextLine());
                break;
            }catch (Exception e){
                System.out.print("输入的数必须为整数.");
            }
        }
        return key;
    }


    private void init() {
        System.out.print("请输入工兵营地的个数:");
        N = getPositiveNum("必须输入整数,请重新输入营地人数:");
        int[] arrays = new int[N];//存储N个营地中，每个营地初始的人数
        for(int i = 0 ; i < arrays.length;i++){
            System.out.print(String.format("请输入第%d个营地的人数:",i+1));
            arrays[i] = getPositiveNum(String.format("输入有误,营地人数必须为整数，请重新输入第%d个营地的人数",i+1));
        }
        root = createTree(arrays);//创建树
    }

    private void preOrder(Tree tree) {
        if (tree != null) {
            System.out.println(tree.id + "->"+tree.value);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    //根据所给营地的信息创建哈夫曼数
    private Tree createTree(int[] arrays) {
        if(arrays==null||arrays.length<=0)
            return null;
        //倒着建树，先生成1号营地的节点，之后继续生成。
        Tree tree = new Tree(0+1,arrays[0]);//生成第一个节点
        Tree node = null;
        Tree mid = null;
        for(int i = 1 ; i < arrays.length;i++){
            node = new Tree(i+1,arrays[i]);
            mid = new Tree(T,tree.value+node.value);
            mid.left = tree;
            mid.right = node;
            tree = mid;
        }
        return tree;
    }

    void opera(){
        while (true) {
            System.out.println("====请输入需要操作的相应数字===");
            System.out.println("=========1.查看敌方营地人数==============");
            System.out.println("=========2.更改敌方营地人数==============");
            System.out.println("=========3.退出==============");
            int key = getPositiveNum("操作数输入错误，必须为整数");
            switch (key){
                case 1:
                    show();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    System.out.println("系统退出.......");
                    System.exit(0);
                default:
                    System.out.println("您输入的信息有误.....");
            }

        }
    }

    private void update() {
        int id;
        while(true){
            System.out.print("请输入营地编号:");
            id = getPositiveNum();
            if(check(1,id))
                break;
            else
                System.out.println("参数检验不合格,请重新输入");
        }
        System.out.print("请输入变动人数(增加1人,输入1,减少1人,输入-1):");
        int m = getNumber();
        String encode = getEncode(id);
        int n = adjustTree(root,encode,id,m);//调整树，并返回修改后的人数.
        if(n>=0)
            System.out.println(String.format("已经修改完成，当前%d号营地共有%d人。",id,n));
        else
            System.out.println("修改失败,当前营地没有这么多人.");
    }

    private int adjustTree(Tree root,String encode, int id, int m) {
        int n = 0;
        Stack<Tree> stack = new Stack<>();
        if(encode==null||encode.length()<=0)
            return 0;
        Tree p = root;
        char c = ' ';
        for(int i = 0;i<encode.length();i++){
            c = encode.charAt(i);
            if(c=='0'){//表示向左走
                stack.push(p);
                p = p.left;
            }
            else if(c=='1'){//表示向右走
                stack.push(p);
                p = p.right;
            }
        }
        if(p.id!=id)
            return -1;
        //防止将营地人数减为负数
        if(m<0&&p.value<-m)
            return -1;
        p.value +=m;//修改营地人数
        //对其所有父节点人数进行修改
        while(!stack.isEmpty())
            stack.pop().value+=m;
        return p.value;
    }

    private void show() {
        int from ,to;
        while(true){
            System.out.print("请输入开始营地:");
            from = getPositiveNum();
            System.out.print("请输入结束营地:");
            to = getPositiveNum();
            if(check(from,to))
                break;
            else
                System.out.println("参数检验不合格,请重新输入");
        }
        int total = 0;
        //为参数加上编码,便于快速在树中找到对应的节点
        String f = getEncode(from);
        if(from==to){
            total = getCampNumber(f);
            System.out.println(String.format("第%d号营地共有:%d人.",from,total));
            return;
        }
        String t = getEncode(to);
        if(from == 1)
            total = getCampParentNumber(t);
        else
            total = getCampParentNumber(t) - getCampParentNumber(f) + getCampNumber(f);
        System.out.println(String.format("从第%d个营地到第%d个营地共有:%d人.",from,to,total));
    }

    private int getCampNumber(String encode) {
        if(encode==null||encode.length()<=0)
            return 0;
        Tree p = root;
        char c = ' ';
        for(int i = 0;i<encode.length();i++){
            c = encode.charAt(i);
            if(c=='0')//表示向左走
                p = p.left;
            else if(c=='1')//表示向右走
                p = p.right;
        }
        return p.value;
    }

    //获取指定编码节点父节点上的人数，其父节点上记录的人数为从1号营地到encode所代表的数字的营地的总人数
    private int getCampParentNumber(String encode) {
        if(encode==null||encode.length()<=0)
            return 0;
        Tree p = root;
        Tree parent = p;
        char c = ' ';
        for(int i = 0;i<encode.length();i++){
            c = encode.charAt(i);
            if(c=='0'){//表示向左走
                parent = p;
                p = p.left;
            }
            else if(c=='1'){//表示向右走
                parent = p;
                p = p.right;
            }
        }
        if(parent.id == T)
            return parent.value;
        return 0;
    }

    private String getEncode(int num) {
        StringBuilder stringBuilder = new StringBuilder();//0表示向左走查左子树，1表示向右走查右子树
        for(int i = 0 ; i < N-num ; i++)
            stringBuilder.append('0');
        if(num!=1)
            stringBuilder.append('1');
        return stringBuilder.toString();
    }

    private boolean check(int from, int to) {
        if(from<=0||from>N)
            return false;
        if(from>to)
            return false;
        if(to<=0||to>N)
            return false;
        return true;
    }

    public static void main(String[] args) {
        HfmTree hfmTree = new HfmTree();
        hfmTree.init();
        hfmTree.opera();
    }

    private class Tree{
        Tree left;//左子树
        Tree right;//右子树
        Integer id;//营地编号
        Integer value;//人数

        public Tree(Integer id, Integer value) {
            this.id = id;
            this.value = value;
        }
    }
}
