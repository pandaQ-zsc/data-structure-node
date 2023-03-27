package com.lee.二叉树;

import com.lee.common.Node;

import java.util.ArrayList;
import java.util.List;

//输入：root = [1,null,3,2,4,null,5,6]
//输出：[5,6,3,2,4,1]
public class _590_N叉树的后序遍历 {
        List<Integer> res;
        public List<Integer> postorder(Node root) {
            res = new ArrayList<>();
            helper(root);
            return res;

        }

        private void helper(Node root) {
            if (root == null) return;
            for (Node tmp : root.children){
                helper(tmp);
            }
            res.add(root.val);
        }


//
//        public List<Integer> postorder2(Node root) {
//        LinkedList<Integer> res = new LinkedList<>();
//        if (root == null) return res;
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            Node pop = stack.pop()
    //          这里的addFirst是精华 也就是说让其反着来
//            res.addFirst(pop.val);
//            int size = pop.children.size();
//            for (int i = 0; i < size; i++) {
//                if (pop.children.get(i)!=null){
//                stack.push(pop.children.get(i));
//                }
//            }
//        }
//        return res;
//    }
}
