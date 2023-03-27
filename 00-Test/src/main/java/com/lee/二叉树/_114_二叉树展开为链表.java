package com.lee.二叉树;

import com.lee.common.TreeNode;

public class _114_二叉树展开为链表 {
    //输入：root = [1,2,5,3,4,null,6]
    //输出：[1,null,2,null,3,null,4,null,5,null,6]
    public void flatten(TreeNode root) {
          if (root == null) return;
          while(root != null ) {
              if (root.left != null){
                  TreeNode prev= root.left;
                  while(prev.right != null){
                      prev = prev.right;
                  }
                  prev.right = root.right;
                  root.right = root.left;
                  root.left = null;
              }
              root = root.right;
          }
    }
}

