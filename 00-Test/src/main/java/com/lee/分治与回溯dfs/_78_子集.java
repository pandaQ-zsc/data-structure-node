package com.lee.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

public class _78_子集 {
    //输入：nums = [1,2,3]
    //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    //:TODO:解法：
    // for循环，横向遍历 {1} -> {2} -> {3}
    //dfs递归：纵向遍历 {1} -> {1,2} -> {1,2,3}
    // 每次遍历加一个大于原来数下标的数到集合，把集合加入到结果集
    // 求取子集问题，不需要任何剪枝！因为子集就是要遍历整棵树。
    List<List<Integer>> res;
    //存放符合条件结果的集合

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null) return  res;
        dfs (nums, new ArrayList<Integer>(),0);
        return res;
    
    }

    private void dfs(int[] nums, List<Integer> list, int start) {
        //遍历这棵树的时候，把所有节点都记录下来
        //最开始 res :{}
        ////因为list是传入的引用，所以需要new一个list加入
        //将当前子集加入到结果中
        res.add(new ArrayList<>(list));
        //终止条件:
        // 不写的话,会无限递归，因为每次递归的下一层就是从i+1开始的。b
        if (start >= nums.length){
            return;
        }
        //for循环，横向遍历 {1} -> {2} -> {3}
        //dfs递归：纵向遍历 {1} -> {1,2} -> {1,2,3}
        for (int i = start; i <nums.length ; i++) {
            // 第一次 list : {1}
            list.add(nums[i]);
            dfs(nums,list,i+1);
            //revers
            list.remove(list.size()-1);

        }
    }




}
