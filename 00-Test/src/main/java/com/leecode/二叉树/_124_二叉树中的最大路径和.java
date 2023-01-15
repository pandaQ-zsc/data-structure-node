package com.leecode.二叉树;

import com.leecode.common.TreeNode;

public class _124_二叉树中的最大路径和 {
    int max = Integer.MIN_VALUE;
    /**
     对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
     1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
     2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
     **/
    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        dfs(root);
        return max;

    }

    private int dfs(TreeNode root) {
        if (root==null) return 0;
        int left = Math.max(dfs(root.left) ,0);
        int right = Math.max(dfs(root.right) ,0);
        max = Math.max(max, left+right+root.val);
       return root.val + Math.max(left,right);
    }

}
