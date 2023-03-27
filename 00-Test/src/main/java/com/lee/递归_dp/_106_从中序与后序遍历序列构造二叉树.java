package com.lee.递归_dp;

import com.lee.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _106_从中序与后序遍历序列构造二叉树 {
    //中序遍历 inorder = [9,3,15,20,7]
    //后序遍历 postorder = [9,15,7,20,3]
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);


    }

    private TreeNode buildTreeHelper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
        //后序为空， 说明没有节点作为根节点了。
        if (p_start == p_end) return null;
        //后序遍历的最后节点是根节点
        int root_val = postorder[p_end-1];
        TreeNode root = new TreeNode(root_val);
        //从中序遍历中找到根节点的位置
        Integer i_root_index = map.get(root_val);
        ////从中序遍历计算出左子树的节点个数，然后在后续遍历就可以划分
        int leftNum = i_root_index - i_start;
        root.left = buildTreeHelper(inorder,i_start,i_root_index,postorder,p_start,p_start+leftNum);
        root.right = buildTreeHelper(inorder,i_root_index+1,i_end,postorder,p_start+leftNum,p_end-1);

        //构建完成，返回构建的根节点
        return root;
    }
}
