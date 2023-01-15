package com.leecode.高频题;

import com.leecode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
