package com.lee.二叉树;

import com.lee.common.TreeNode;

import java.util.*;

public class _104_二叉树的最大深度 {
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null)
                        queue.offer(poll.right);
                }
            }
            deep++;
        }
        return deep;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int deep = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right!=null){
                    queue.add(poll.right);
                    }
                }
            }
            deep++;
        }
        return deep;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }
}
