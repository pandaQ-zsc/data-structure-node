package com.leecode.递归_dp;

import com.leecode.common.TreeNode;

//        //这道题递归条件里分为三种情况
//        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
public class _111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

//    public int minDepth(TreeNode root) {
//        if(root == null) return 0;
//        //这道题递归条件里分为三种情况
//        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
//        if(root.left == null && root.right == null) return 1;
//        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
//        int m1 = minDepth(root.left);
//        int m2 = minDepth(root.right);
//        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
//        if(root.left == null || root.right == null) return m1 + m2 + 1;
//
//        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
//        return Math.min(m1,m2) + 1;
//    }

}
