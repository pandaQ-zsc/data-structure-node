package com.leecode.递归_dp;

import com.leecode.common.TreeNode;

public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
