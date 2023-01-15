package com.leecode.递归_dp;

import com.leecode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
//输入：root = [2,1,3]
//输出：true



public class _98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
       return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    private boolean helper(TreeNode root, long maxValue, long minValue) {
        // //遍历到空了说明顺序无误往上层抛true
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return helper(root.left,root.val,minValue) && helper(root.right,maxValue,root.val);
    }


//在这里需要记住一个知识点：二叉搜索树中序遍历结果就是有序的
//思路1：将二叉搜索树中序遍历一次，然后将结果集逐个比对

//    List<TreeNode> res;
//    public boolean isValidBST(TreeNode root) {
//
//        res = new ArrayList<>();
//        helper(root);
//        if (res.size() < 2) return  true;
//        for (int i = 1; i < res.size(); i++) {
//            if (res.get(i).val <= res.get(i-1).val) return false;
//        }
//        return true;
//    }
//
//    private void helper(TreeNode root) {
//        if (root == null) return;
//        helper(root.left);
//        res.add(root);
//        helper(root.right);
//    }

}
