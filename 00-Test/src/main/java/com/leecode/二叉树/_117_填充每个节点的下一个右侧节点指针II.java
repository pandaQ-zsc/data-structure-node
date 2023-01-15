package com.leecode.二叉树;

import com.leecode.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class _117_填充每个节点的下一个右侧节点指针II {
    public Node connect(Node root) {
        if (root  == null){
            return  root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll!= null){
                    if (i < size -1){
                        poll.next = queue.peek();
                    }
                    if (poll.left != null){
                        queue.offer(poll.left);
                    }
                    if (poll.right != null){
                        queue.offer(poll.right);
                    }
                }
            }
        }
        return root;
    }
}
