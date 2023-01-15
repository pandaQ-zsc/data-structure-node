package com.leecode.二叉树;

import com.leecode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515_在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    max = Math.max(max, poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right!=null){
                        queue.offer(poll.right);
                    }
                }
            }
            res.add(max);
        }
        return res;
    }
}
