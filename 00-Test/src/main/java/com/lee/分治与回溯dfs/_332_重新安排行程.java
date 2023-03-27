package com.lee.分治与回溯dfs;

import java.util.*;

public class _332_重新安排行程 {
    //输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
    //输出：["JFK","MUC","LHR","SFO","SJC"]
    //
    List<String> res ;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        // from , (dest  number)
        Map<String, TreeMap<String,Integer>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            String from  = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new TreeMap<>());
            TreeMap<String,Integer> treeMap = map.get(from);
            treeMap.put(to,treeMap.getOrDefault(to,0) + 1);
        }
        res.add("JFK");
        dfs(tickets,map,0);
        return res;
    }

    private boolean dfs(List<List<String>> tickets, Map<String, TreeMap<String, Integer>> map, int progress){
        if(progress == tickets.size()){
            return true;
        }

        TreeMap<String, Integer> tos = map.get(res.get(res.size() - 1));
        if(tos == null || tos.isEmpty() || tos.size() == 0)
            return false;

        for(String str : tos.keySet()){
            if(tos.get(str) == 0)
                continue;

            res.add(str);
            tos.put(str, tos.get(str) - 1);

            if(dfs(tickets, map, progress + 1))
                return true;

            res.remove(res.size() - 1);
            tos.put(str, tos.get(str) + 1);
        }

        return false;
    }


}
