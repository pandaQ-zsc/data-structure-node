package com.lee.二叉树;

import com.lee.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                    if (i == size - 1) {
                        res.add(poll.val);
                    }
                }

            }
        }
        return res;
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return  res;
    }

    private void dfs(TreeNode root, int deep) {
        if (root == null) return;
        if (res.size() == deep){
            res.add(root.val);
        }
        deep++;
        dfs(root.right,deep);
        dfs(root.left,deep);
    }
}