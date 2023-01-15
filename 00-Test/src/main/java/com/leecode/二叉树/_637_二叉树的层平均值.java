package com.leecode.二叉树;

import com.leecode.common.TreeNode;

import java.util.*;

public class _637_二叉树的层平均值 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    sum += poll.val;
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }
            double avg = sum / size;
            res.add(avg);
        }
        return res;
    }
}
