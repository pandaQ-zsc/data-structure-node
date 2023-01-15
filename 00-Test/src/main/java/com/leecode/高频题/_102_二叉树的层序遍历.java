package com.leecode.高频题;

import com.leecode.common.TreeNode;
import com.leecode.链表.ListNode;

import java.util.*;

public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                list.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
