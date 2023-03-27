package com.lee.递归_dp;

import com.lee.common.TreeNode;

public class _235_二叉搜索树的最近公共祖先 {
    //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //输出: 6
    //解释: 节点 2 和节点 8 的最近公共祖先是 6。
    ///
    //思路：
    //
    //如果两个节点都小于root，在左边
    //如果两个节点都大于root，在右边
    //如果一个大于root一个小于root或者有一个等于root，就是root

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //维护参数中  p < q 的关系
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        //有一个等于
        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        //两个都小于
        if (q.val < root.val) {
            //返回一个小一点的root
            return lowestCommonAncestor(root.left, p, q);
            //两个都大于
        } else if (p.val > root.val) {
            //返回一个大一点的root
            return lowestCommonAncestor(root.right, p, q);
        } else { //一个小 一个大
            return root;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        //两个都小
        if (q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}