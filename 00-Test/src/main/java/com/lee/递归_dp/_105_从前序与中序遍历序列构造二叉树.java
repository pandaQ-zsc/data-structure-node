package com.lee.递归_dp;

import com.lee.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _105_从前序与中序遍历序列构造二叉树 {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return builderTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);


    }

    private TreeNode builderTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        //前序遍历为空，说明没有节点作为根节点。
        if (p_start == p_end) return null;
        //先序遍历获得的节点就是根节点
        //3
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //从中序遍历中找到根节点的位置
        //  i_root_index = 1
        int i_root_index = map.get(root_val);
        //中序遍历计算出左子树的节点个数，然后在前序中划分
        //   1-0 = 1;
        int leftNum = i_root_index - i_start;
        //递归构建左子树：传入左子树对应的参数。
        root.left = builderTreeHelper(preorder, p_start + 1, p_start + 1 + leftNum, inorder, i_start, i_root_index);
        //递归构建右子树:传入对右子树所对应的参数
        root.right = builderTreeHelper(preorder, p_start + 1 + leftNum, p_end, inorder, i_root_index + 1, i_end);
        return root;

    }


}
