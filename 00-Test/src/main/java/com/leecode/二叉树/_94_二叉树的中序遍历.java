package com.leecode.二叉树;

import com.leecode.common.TreeNode;

import java.util.*;

//输入：root = [1,null,2,3]
//输出：[1,3,2]
public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    //递归
    List<Integer> list = new LinkedList<>();
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root  == null){
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return  list;
    }
}
