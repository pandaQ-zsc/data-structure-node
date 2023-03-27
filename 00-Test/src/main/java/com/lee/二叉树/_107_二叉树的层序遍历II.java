package com.lee.二叉树;

import com.lee.common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _107_二叉树的层序遍历II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root ==null) return  res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll!=null){
                    list.add(poll.val);
                    if (poll.left!=null){
                        queue.offer(poll.left);
                    }
                    if (poll.right!=null){
                        queue.offer(poll.right);
                    }
                }
            }
          res.addFirst(list);
        }
        return res;

    }
}
