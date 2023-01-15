package com.leecode.高频题;

import com.leecode.common.TreeNode;
//https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
public class _543_二叉树的直径 {
    int res ;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        res= 1;
        dfs(root);
        return res-1;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(left + right+1,res);
        return Math.max(left,right)+1;
    }

}
