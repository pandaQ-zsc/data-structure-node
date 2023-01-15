package com.leecode.贪心;

import java.util.Arrays;

public class _455_分发饼干 {
    //    g：孩子胃口大小  s : 饼干大小
    //输入: g = [1,2,3], s = [1,1]
    //如果 s[j] >= g[i]
    //输出: 1
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie =0;
        while(child<g.length&& cookie < s.length){
            if (g[child] <= s[cookie]){
                cookie++;
                child++;
            }else {
                cookie++;
            }
        }
        return child;
    }
}
