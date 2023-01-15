package com.leecode.高频题;

import com.leecode.common.TreeNode;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class _236_二叉树的最近公共祖先 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {//当遍历到叶结点后就会返回null
                return root;
            }
            if (root == p || root == q) {//当找到p或者q的是时候就会返回pq
                return root;/*当然，值得一提的是，如果公共祖先是自己（pq），并不需要寻找另外
                     一个，我们在执行前序遍历会先找上面的，后找下面的，我们会直接返回公共祖先。*/
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);//返回的结点进行保存，可能是null
            TreeNode right = lowestCommonAncestor(root.right, p, q);//也可能是pq，还可能是公共祖先
            if (left != null && right != null) {
                return root;//如果左右都存在，就说明pq都出现了，这就是，公共祖先，此时不用考虑公共祖先是自己的情况，因为上面已经做过判断了。
            } else if (left != null) {//能来到这里 left == null || right==null
                return left;//还有一种可能就是，由下面返回的公共祖先，并将这个值一路返回到最表层
            } else return right;
        }

        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null ) return null;
            if (root ==p || root == q) return root;
            TreeNode left = lowestCommonAncestor2(root.left ,p ,q);
            TreeNode right = lowestCommonAncestor2(root.right ,p ,q);
            if (left != null && right != null){
                    return root;
            } else if (left != null) {
                return left;
            }else {
                return right;
            }
        }
    }
}
