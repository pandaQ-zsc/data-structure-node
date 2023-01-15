package com.sort;


import java.util.HashMap;
//要让 put 和 get 方法的时间复杂度为 O(1)，
// 我们可以总结出 cache 这个数据结构必要的条件：查找快，插入快，删除快，有顺序之分。

//因为显然 cache 必须有顺序之分，以区分最近使用的和久未使用的数据；
// 而且我们要在 cache 中查找键是否已存在；如果容量满了要删除最后一个数据；
// 每次访问还要把数据插入到队头。
//

public class _重点_146_LRU缓存机_test2 {
    public class LRUCache {
        class Node {
            public int key, val;
            public Node next, prev;

            public Node(int k, int v) {
                this.key = k;
                this.val = v;
            }
        }

        class DoubleList {

            private Node head, tail;
            private int size;

            public void addFirst(Node node) {
                if (head == null) {
                    head = tail = node;
                } else {
                    Node n = head;
                    n.prev = node;
                    node.next = n;
                    head = node;
                }
                size++;
            }

            public void remove(Node node) {
                if (head == node && tail == node) {
                    head = null;
                    tail = null;
                } else if (tail == node) {
                    node.prev.next = null;
                    tail = node.prev;
                } else if (head == node) {
                    node.next.prev = null;
                    head = node.next;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                size--;
            }

            public Node removeLast() {
                Node node = tail;
                remove(tail);
                return node;
            }

            public int size() {
                return size;
            }
        }

        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        public void put(int key, int value) {
            Node x = new Node(key, value);

            if (map.containsKey(key)) {
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                if (cap == cache.size()) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }
}
