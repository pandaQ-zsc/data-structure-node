package com.lee.asia;

import com.lee.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiong.qiang
 * @date: 2023/3/27 20:37
 */

//输入：root = [1,null,2,3]
//输出：[1,2,3]
public class _144_PreorderTraversal {
//    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        treeNode.right=right;
        right.left = left;
        List<Integer> integers = preorderTraversal(treeNode);
        System.out.println(integers);

    }
    static ArrayList<Integer> list = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        preSearch(root) ;
        return list;
    }

    private static void preSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
