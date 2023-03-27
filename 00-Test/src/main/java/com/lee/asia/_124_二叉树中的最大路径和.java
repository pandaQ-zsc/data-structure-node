package com.lee.asia;

import com.lee.common.TreeNode;

public class _124_二叉树中的最大路径和 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
