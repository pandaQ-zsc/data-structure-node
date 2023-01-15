package com.leecode.二叉树;

import com.leecode.common.Node;

import java.util.*;

//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,3,5,6,2,4]
public class _589_N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return  res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            res.add(pop.val);
            int size = pop.children.size();
            for (int i = size-1; i >=0 ; i--) {
                if (pop.children.get(i)!=null){
                  stack.push(pop.children.get(i));
                }
            }
        }
        return res;
    }

    List<Integer> res;
    public List<Integer> preorder2(Node root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    private void helper(Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node tmp : root.children){
            helper(tmp);
        }
    }

}