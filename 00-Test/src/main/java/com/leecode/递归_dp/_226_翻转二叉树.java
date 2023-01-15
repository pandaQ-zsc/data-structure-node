package com.leecode.递归_dp;

import com.leecode.common.TreeNode;

public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
