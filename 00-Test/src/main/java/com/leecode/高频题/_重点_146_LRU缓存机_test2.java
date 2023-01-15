package com.leecode.高频题;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//要让 put 和 get 方法的时间复杂度为 O(1)，
// 我们可以总结出 cache 这个数据结构必要的条件：查找快，插入快，删除快，有顺序之分。

//因为显然 cache 必须有顺序之分，以区分最近使用的和久未使用的数据；
// 而且我们要在 cache 中查找键是否已存在；如果容量满了要删除最后一个数据；
// 每次访问还要把数据插入到队头。
//

public class _重点_146_LRU缓存机_test2 {
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node first;
    private Node last;

    _重点_146_LRU缓存机_test2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null){
            return -1;
        }else {
            removeNode(node);
            addAfterFirst(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null){
            if (map.size() == capacity){
                map.remove(last.prev.key);
                removeNode(last.prev);
            }
            map.put(key,node= new Node(key,value));
            addAfterFirst(node);
        }else {
            node.value = value;
            removeNode(node);
            addAfterFirst(node);
        }
    }

    private void addAfterFirst(Node node) {
        node.next = first.next;
        first.next.prev = node;

         first.next = node;
         node.prev = first;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private static class Node {
        Node prev;
        Node next;
        int key;
        int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
