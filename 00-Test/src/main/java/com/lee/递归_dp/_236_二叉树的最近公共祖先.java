package com.lee.递归_dp;

import com.lee.common.TreeNode;

public class _236_二叉树的最近公共祖先 {
//当我们用递归去做这个题时不要被题目误导，应该要明确一点
//这个函数的功能有三个：给定两个节点 pp 和 qq
//
//如果 pp 和 qq 都存在，则返回它们的公共祖先；
//如果只存在一个，则返回存在的一个；
//如果 pp 和 qq 都不存在，则返回NULL
//本题说给定的两个节点都存在，那自然还是能用上面的函数来解决
//
//具体思路：
//（1） 如果当前结点 rootroot 等于 NULL，则直接返回 NULL
//（2） 如果 rootroot 等于 pp 或者 qq ，那这棵树一定返回 pp 或者 qq
//（3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 leftleft 和 rightright 表示
//（4） 此时若leftleft为空，那最终结果只要看 rightright；若 rightright 为空，那最终结果只要看 leftleft
//（5） 如果 leftleft 和 rightright 都非空，因为只给了 pp 和 qq 两个结点，都非空，说明一边一个，因此 rootroot 是他们的最近公共祖先
//（6） 如果 leftleft 和 rightright 都为空，则返回空（其实已经包含在前面的情况中了）
//
//时间复杂度是 O(n)O(n)：每个结点最多遍历一次或用主定理，空间复杂度是 O(n)O(n)：需要系统栈空间
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    //使用函数后可认为左右函数已经计算出结果。
    //先去左边子树搜索 p ,q的祖宗
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    //再去右边子树搜索 p ,q的祖宗
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    //如果左子树中没有找到结果， 那么就去右子树中去查找 p ,q的祖宗
    //这里的right  就是lowestCommonAncestor(root.right, p, q)
    if (left == null) return right;
    if (right == null) return left;
    //如果左右子树中都没有，那么就说明左右子树中一边各一个,  root就是祖宗
    return root;
}
}
