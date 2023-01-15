package com.leecode.二叉树;

import com.leecode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
//         4
//       /   \
//      2     7
//     / \   / \
//    1   3 6   9

public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public TreeNode invertTree2(TreeNode root) {
        TreeNode rightTree = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(rightTree);
        return root;
    }
    public TreeNode invertTree3(TreeNode root) {
        if (root ==null) return null;
        Queue<TreeNode>queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode tmp = poll.left;
            poll.left = poll.right;
            poll.right = tmp;
            if (poll.left!=null){
            queue.add(poll.left);
            }
            if (poll.right!=null){
            queue.add(poll.right);
            }
        }
        return root;
    }


    }
