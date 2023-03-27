package com.lee.分治与回溯dfs;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/restore-ip-addresses/solution/dai-ma-sui-xiang-lu-93-fu-yuan-ip-di-zhi-pzjo/
public class _93_参考_复原IP地址 {
    //输入：s = "25525511135"
    //输出：["255.255.11.135","255.255.111.35"]

    // 每一个点号之间间距不超过3，不小于1，再加上每段ip的一些限制条件

    List<String>res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return  res;
        dfs(s,0,0);
        return res;
    }

    private void dfs( String s,int start,int pointNum) {
        //对最后一段进行分析
       if (pointNum == 3){
            if (isValid(s,start,s.length()-1)){
                res.add(s);
            }
       }
        for (int i = start; i <s.length() ; i++) {
            if (isValid(s,start,i)){
                s = s.substring(0,i+1) + "." + s.substring(i+1);
                dfs(s,i + 2,pointNum+1);
                s = s.substring(0,i+1) + s.substring(i+2);//回溯 删掉逗号，但是后面的数值没有
            }else {
                break;
            }
        }
    }

    //[start , end]
    private boolean isValid(String s, int start, int end) {
        if (start > end){
            return  false;
        }
        //0开头的数字不合法
        if (s.charAt(start) == '0' && start != end){
            return false;
        }
        int num = 0 ;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return  false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255){ //如果大于255不合法
                return  false;
            }
        }
        return true;
    }
}
