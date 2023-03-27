package com.lee.二叉树;

import com.lee.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _112_路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right==null && targetSum-root.val == 0) return true;
        return hasPathSum(root.left,targetSum-root.val)|| hasPathSum(root.right,targetSum-root.val);
    }
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root,targetSum,0);

    }

    private boolean dfs(TreeNode root, int targetSum, int curSum) {
        if (root == null) return false;
        curSum += root.val;
        if (root.left == null && root.right == null){
            return curSum == targetSum;
        }
        return dfs(root.left, targetSum,curSum) ||dfs(root.right, targetSum,curSum);
    }


    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        queue.offer(root);
        valQueue.offer(root.val);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer tmp = valQueue.poll();
            if (poll.left == null && poll.right == null) {
                if (tmp == targetSum) {
                    return true;
                }
                continue;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
                valQueue.offer(tmp + poll.left.val);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                valQueue.offer(tmp + poll.right.val);
            }
        }
        return false;
    }
}
