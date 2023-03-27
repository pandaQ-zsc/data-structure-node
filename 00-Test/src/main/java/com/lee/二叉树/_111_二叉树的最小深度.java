package com.lee.二叉树;

import com.lee.common.TreeNode;

public class _111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    int min = Integer.MAX_VALUE;

    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        dfs(root,1);
        return  min;
    }

    private void dfs(TreeNode root, int level) {
        if (root.left == null && root.right == null){
            min = Math.min(min,level);
        }
        if (root.left !=null){
            dfs(root.left,level+1);
        }
        if (root.right != null){
            dfs(root.right, level+1);
        }
    }
}
