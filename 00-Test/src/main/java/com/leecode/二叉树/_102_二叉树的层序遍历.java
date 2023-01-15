package com.leecode.二叉树;

import com.leecode.common.TreeNode;
import com.leecode.链表.ListNode;
import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;

import java.util.*;
//    3
//   / \
//  9  20
//    /  \
//   15   7

//[
//  [3],
//  [9,20],
//  [15,7]
//]
public class _102_二叉树的层序遍历 {
    class Solution {
        public List<List<Integer>> levelOrder2(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll != null) {
                        list.add(poll.val);
                        if (poll.left != null) {
                            queue.add(poll.left);
                        }
                        if (poll.right != null) {
                            queue.add(poll.right);
                        }
                    }
                }
                res.add(list);
            }
            return res;
        }


        public List<List<Integer>> levelOrder(TreeNode root) {
            new HashMap<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll != null) {
                        tmp.add(poll.val);
                        if (poll.left != null) {
                            queue.offer(poll.left);
                        }
                        if (poll.right != null) {
                            queue.offer(poll.right);
                        }
                    }
                }
                res.add(tmp);
            }
            return res;
        }
    }
}
