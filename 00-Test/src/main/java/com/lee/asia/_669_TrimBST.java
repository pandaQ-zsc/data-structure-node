package com.lee.asia;

import com.lee.common.TreeNode;

/**
 * @author: xiong.qiang
 * @date: 2023/4/3 15:46
 */

//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
// 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在唯一的答案。
//
//所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
//
//输入：root = [1,0,2], low = 1, high = 2
//输出：[1,null,2]
public class _669_TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return root;

        //下面两个if相当于删除不满足要求的节点（在范围外的节点）
        if (root.val < L)
            return trimBST(root.right, L, R);//返回修剪过的右子树。抱有一丝丝期望，希望右子树能够满足要求，因为右子树的值大于当前根节点的值
        if (root.val > R)
            return trimBST(root.left, L, R);//返回修剪过的左子树，抱有一丝丝期望，希望左子树能够满足要求，因为左子树的值小于当前根节点的值

        //（处理在范围内的节点）
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }


    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null){
            return null;
        }
        if (root.val < low){
            return  trimBST2(root.right,low,high);
        }
        if (root.val > high){
            return  trimBST2(root.left,low,high);
        }
        root.left = trimBST2(root.left,low,high);
        root.right  = trimBST2(root.right,low,high);
        return root;
    }
}
