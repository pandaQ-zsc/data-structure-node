package com.leecode.分治与回溯dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _332_费时_重新安排行程 {

    List<String> res;
    boolean flag;

    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>(); // 存储最终结果
        flag = false; // 标记最终结果是否找到
        // 将票组按照目的地的字典顺序从小到大排序
        tickets.sort(Comparator.comparing(o -> o.get(1)));
        dfs(tickets, 0, new boolean[tickets.size()], new ArrayList<>(), "JFK"); // DFS + 回溯
        res.add(0, "JFK"); // 将出发地添加到结果当中
        return res; // 返回结果
    }

    private void dfs(List<List<String>> tickets, int level, boolean[] visited, List<String> ans, String lastPop) {
        if (level == tickets.size()) { // 如果第一次找到了答案，则这个答案就是最优的，因为已经排序好了
            res = new ArrayList<>(ans); // 将结果赋值
            flag = true; // 将flag设置为true
            return;
        }

        for (int i = 0; i < tickets.size(); i++) { // DFS + 回溯
            List<String> ticket = tickets.get(i);
            if (ticket.get(0).equals(lastPop) && !visited[i] && !flag) {
                ans.add(ticket.get(1));
                visited[i] = true;
                dfs(tickets, level + 1, visited, ans, ticket.get(1));
                visited[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }
}

