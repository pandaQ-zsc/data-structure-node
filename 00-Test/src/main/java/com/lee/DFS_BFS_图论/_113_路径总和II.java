package com.lee.DFS_BFS_图论;

import com.lee.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _113_路径总和II {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root,targetSum,new ArrayList<>(),list);
        return list;

    }

    private void dfs(TreeNode node, int targetSum,List<Integer> nums,List<List<Integer>>list) {
        if (node == null) return;
        targetSum -= node.val;
        nums.add(node.val);
        if (node.left==null && node.right==null){
            if (targetSum == 0) list.add(new ArrayList<>(nums));
        }else {
         dfs(node.left,targetSum,nums,list);
         dfs(node.right,targetSum,nums,list);
        }
        nums.remove(nums.size()-1);

    }
}
