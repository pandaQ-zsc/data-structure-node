package com.leecode.二叉树;

import com.leecode.common.TreeNode;
/**
 解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
 1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
 2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
 需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
 **/
public class _687_最长同值路径 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root,root.val);
        return max;
    }

    private int dfs(TreeNode root, int preVal) {
      if (root == null) return 0;
      int left = dfs(root.left,root.val);
      int right = dfs(root.right,root.val);
      max = Math.max(max,left + right);
      if (root.val == preVal){
          return Math.max(left,right)+1;
      }
      return 0;
    }
}
