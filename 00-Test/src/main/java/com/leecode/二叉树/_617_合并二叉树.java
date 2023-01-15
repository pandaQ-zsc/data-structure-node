package com.leecode.二叉树;

import com.leecode.common.TreeNode;

public class _617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public TreeNode mergeTrees2(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        return  dfs(r1,r2);
    }

    private TreeNode dfs(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 ==null){
            return r1 == null ? r2 : r1;
        }
        r1.val  += r2.val;
        r1.left = dfs(r1.left,r2.left);
        r1.right = dfs(r1.right,r2.right);
        return r1;
    }

}
