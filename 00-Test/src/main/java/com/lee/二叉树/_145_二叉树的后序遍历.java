package com.lee.二叉树;

import com.lee.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class _145_二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop == null) continue;
            res.add(pop.val);
            stack.push(pop.left);
            stack.push(pop.right);

        }
        Collections.reverse(res);
        return res;
    }
}
