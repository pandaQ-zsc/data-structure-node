package com.leecode.高频题;

import com.leecode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        return Math.max(left,right);
    }
}
