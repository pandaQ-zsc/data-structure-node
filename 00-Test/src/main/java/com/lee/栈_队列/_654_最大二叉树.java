package com.lee.栈_队列;

import com.lee.common.TreeNode;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return findRoot(nums, 0, nums.length);
    }

    private TreeNode findRoot(int[] nums, int l, int r) {
        if (l == r) return null;
        int maxIndex = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = findRoot(nums, l, maxIndex);
        root.right = findRoot(nums, maxIndex+1, r);
        return  root;
    }
}
