package com.leecode.二叉树;

import com.leecode.common.TreeNode;

public class _110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int max = Math.max(deep(root.left),deep(root.right));
            int min = Math.min(deep(root.left),deep(root.right));
            // 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
            // 这里有提到每个. 因此需要后面子代也是平衡的。
            // return (max-min)<=1;
            if (max - min > 1) return  false;
            return isBalanced(root.left) && isBalanced(root.right);

    }
    //暴力dfs
    boolean flag = true;
    public boolean isBalanced2(TreeNode root) {
        if (root == null){
            return true;
        }
        dfs(root);
        return flag;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (Math.abs(deep(root.right)-deep(root.left))>1){
            flag = false;
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }


    public int deep(TreeNode root) {
        if (root == null) return 0;
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }
}
