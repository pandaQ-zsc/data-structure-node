package com.leecode.二叉树;

import com.leecode.common.Node;

import java.util.*;

public class _429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return  res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                 if (poll!=null){
                    list.add(poll.val);
                    for (Node child : poll.children ){
                        queue.offer(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
