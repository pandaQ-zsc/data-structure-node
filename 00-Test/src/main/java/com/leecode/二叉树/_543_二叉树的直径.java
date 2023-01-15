package com.leecode.二叉树;

import com.leecode.common.TreeNode;
//          1
//         / \
//        2   3
//       / \
//      4   5
//返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
public class _543_二叉树的直径 {
    //dfs
    //遍历每一个节点，以每一个节点为中心点计算最长路径
    // 最长路径:（左子树边长+右子树边长）更新全局变量max。
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root ==null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max,left + right);
        return Math.max(left,right)+1;
    }


    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null ) return 0;
        //左右子树的最大深度相加就是最长路径的边数量
        int len = deep(root.left) + deep(root.right);
        //左右子树的最大路径
        int a = Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));
        return Math.max(a,len);


    }
    public int deep(TreeNode root){
        if (root == null) return 0;
        if (root.left== null && root.right == null) return 1;
        return Math.max(deep(root.left),deep(root.right))+1;
    }
}
