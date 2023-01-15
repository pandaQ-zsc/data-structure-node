package com.leecode.高频题;

import com.leecode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root!=null){
                stack.add(root);
                root = root.left;
            }else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                root= pop.right;
            }
        }
        return res;
    }




        public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) return;
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }
}
