package com.leecode.common;

public class Main3 {
    //2,2,3,5
    //2
    // 1,2,2,3,3,3
    //3
    public int findLucky (int[] arr) {
        int []count = new int[100];
        int max = 0 ;
        int ans = -1;
        for (int num : arr){
            count[num] ++;
            max = Math.max(max, num);
        }
        for (int i = 1; i <= max; i++) {
            if (count[i] == i){
                ans = (ans > i) ? ans : i;
            }

        }
        return ans;
    }

    public boolean isSameTree (TreeNode p, TreeNode q) {
        // write code here
        if (p == null && q == null ){
            return true;
        }
        if (p == null) return false;
        if (q == null) return false;
        if (p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else {
            return false;
        }
    }
}
