package com.lee.asia;


import java.util.LinkedHashMap;
import java.util.Map;

//調用api
public class _重点_146_LRU缓存机_test1 {
    public class LRUCache {
        //        int capacity;
        LinkedHashMap<Integer, Integer> cache;

        public LRUCache(int capacity) {
//            this.capacity = capacity;
            cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return cache.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }


}
