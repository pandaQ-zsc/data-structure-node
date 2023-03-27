package com.lee.二叉树;

import com.lee.common.TreeNode;

public class _99_恢复二叉搜索树 {
    //上一次中序遍历过的节点
    private TreeNode prev;
    //第一个错误节点
    private TreeNode first;
    //第二个错误节点
    private TreeNode second;
    //第一个错误的二叉搜索树
    public void recoverTree(TreeNode root) {
        findWrongNodes(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void findWrongNodes(TreeNode root) {
        if (root == null) return;
        findWrongNodes(root.left);
        //出现逆序对
        if (prev!=null && prev.val> root.val){
            //第二个错误节点： 最后一个逆序对中较小的那个节点
            second = root;
            //第一个错误节点： 第一个逆序对中较大的那个节点
            if (first == null){
                first = prev;
            }
        }
        prev = root;
        findWrongNodes(root.right);
    }

}
