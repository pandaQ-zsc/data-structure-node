package com.lee.asia;

import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    private Map<Integer, Node> map;
    private int capacity;
    private Node first;
    private Node last;

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            removeNode(node);
            addAfterFirst(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {  //map中有
            node.value = value;
            removeNode(node);
        } else {//map中没有
            if (map.size() == capacity) {
                map.remove(last.prev.key);
                removeNode(last.prev);
            }
            map.put(key, node = new Node(key, value));
        }
        addAfterFirst(node);
    }


    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        first.next = last;
        last.prev = first;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addAfterFirst(Node node) {
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
        node.prev = first;
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

