package com.lee.二叉树;

import cn.hutool.core.convert.Convert;
import com.lee.common.TreeNode;
import com.mj.BinarySearchTree;
import com.mj.printer.BinaryTrees;

    import java.sql.Array;
import java.util.*;

/**
 * @author: xiong.qiang
 * @date: 2023/6/6 09:52
 */
public class TestDemo1 {
     public static List<Integer> levelOrder(TreeNode root){
         Queue<TreeNode> queue = new LinkedList<>();
         ArrayList<Integer> list = new ArrayList<>();
         queue.add(root);
         while (queue.size() != 0){
             TreeNode  node = queue.poll();
             list.add(node.val);
             if (node.left != null){
             queue.add( node.left);
             }
             if (node.right != null){
             queue.add( node.right);
             }
         }
         return list;
     }
     void insert(int num , TreeNode root){
         if (root == null) return;
         TreeNode pre =  null;
         TreeNode cur = root;
         while(cur != null){
             if (cur.val == num) return;
             pre  = cur;
             if (cur.val > num){
                 cur = cur.left;
             }
             if (cur.val< num){
                 cur = cur.right;
             }
         }
         TreeNode node = new  TreeNode(num);
         if (num > pre.val){
             pre.right = node;
         }
         if (num < pre.val){
             pre.left = node;
         }
     }

    public static void main(String[] args) {
        //根据层序遍历，打印二叉树
        Integer date[] = new Integer[] { 7, 4, 9, 2, 5, 8, 11, 3, 12, 1};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < date.length; i++) {
            bst.add(date[i]);
        }
        BinaryTrees.println(bst);
        //完全二叉树非常适合使用数组来表示。

        //数组转换成列表
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,1));
        System.out.println(list);
        System.out.println("======");
        //列表转化成数组。
        Integer[] intArray = Convert.toIntArray(list);
        String arrayString = Arrays.toString(intArray);
        System.out.println(arrayString);

        //构建大顶堆
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        System.out.println("xxx");

        System.out.println("version2");


    }
}
