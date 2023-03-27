package com.lee.二叉树;

import com.lee.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

//方法、前缀和 https://leetcode-cn.com/problems/path-sum-iii/solution/tong-ge-lai-shua-ti-la-qian-zhui-he-tu-j-trcq/
///哈希表中记录了 10 这个数值，当遍历到 18 时，发现哈希表中有 18 - 8 = 10，总次数加上 10 出现的次数即可。
//currSum-target相当于找路径的起点，起点的sum,+target=currSum，当前点到起点的距离就是target
//key存放的是前缀和，而 value 存放的是这个前缀和的个数， 如果有相同的则个数加1，
// 而在退出这个节点的递归的时候则对这个 key 的 value 值减1。
//
//在现在的这个思路下，我们还可以在初始的 HashMap中多增加一个
// key = 0 、value = 1来表示根节点上面一个不存在的节点的情况。
//
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
public class _437_路径总和III {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return count;
        // key 是前缀和， value是前缀和的个数
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        dfs(root,map,0,targetSum);
        return count;
    }

    private void dfs(TreeNode node, Map<Integer, Integer> map, int curSum, int targetSum) {
        if (node == null){
            return;
        }
        curSum += node.val;
        count += map.getOrDefault(curSum-targetSum,0);
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        dfs(node.left,map,curSum,targetSum);
        dfs(node.right,map,curSum,targetSum);
        map.put(curSum,map.getOrDefault(curSum,0)-1);
    }


}
