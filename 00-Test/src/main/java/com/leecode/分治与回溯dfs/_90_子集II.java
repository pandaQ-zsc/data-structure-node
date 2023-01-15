package com.leecode.分治与回溯dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

//本题也可以不适用used数组来去重，因为递归的时候下一个startIndex是i+1而不是0。
//如果要是全排列的话，每次要从0开始遍历，为了跳过已入栈的元素，需要使用used。
public class _90_子集II {
    List<List<Integer>> res;
    List<Integer>list;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        if (nums == null)
            return res;
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i <nums.length ; i++) {
            //注意这里是i > start  这样的话只针对横向取相同数跳过
            //因为dfs纵向的话 i最开始是等于start的。
            // 如果改成了i>0的话，横向和纵向都不能取两次2
            if (i >start && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            dfs(nums,i+1);
            list.remove(list.size()-1);
        }

    }

}
