package com.leecode.字符串;

import com.leecode.common.TreeNode;

//字符串序列化
public class _572_另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        return postSerialize(root).contains(postSerialize(subRoot));
    }

    private String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(root, sb);
        return sb.toString();
    }

    private void postSerialize(TreeNode node, StringBuilder sb) {
        if (node.left == null) {
            sb.append("#!");
        }else {
            postSerialize(node.left,sb);
        }
        if (node.right == null) {
            sb.append("#!");
        }else {
            postSerialize(node.right,sb);
        }
        sb.append(node.val).append("!");
    }
}
