package com.leecode.二叉树;

import com.leecode.common.TreeNode;

import java.util.*;

public class _144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return  new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur == null) {
                continue;
            }
            res.add(cur.val);
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return res;

    }
}
