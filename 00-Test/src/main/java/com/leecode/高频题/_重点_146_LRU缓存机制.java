package com.leecode.高频题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _重点_146_LRU缓存机制 {
    private Map<Integer, Node> map;
    private int capacity;
    //虚拟头结点
    private Node first;
    //虚拟尾节点
    private Node last;


    public _重点_146_LRU缓存机制(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        //最开始的时候虚拟头结点和尾节点，首尾互相连
        first.next = last;
        last.next = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        removeNode(node);
        addAfterFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) { //链表中有这个值
            node.value = value;
            removeNode(node);
        } else {//链表中没有这个值。
            //满了，淘汰
            if (map.size() == capacity) {
                //淘汰最近最少使用的Key - value
                //map中删除
                map.remove(last.prev.key);
                //链表中删除
                removeNode(last.prev);

            }
            //map中添加一个新的key,value
            map.put(key, node =new Node(key,value));
            //链表中插入节点
        }
        addAfterFirst(node);
    }

    /**
     * 将 node 节点插入到first节点的后面
     *
     * @param node
     */
    private void addAfterFirst(Node node) {
        //node和first.next
        node.next = first.next;
        first.next.prev = node;
        // node与first
        first.next = node;
        node.prev = first;
    }

    /**
     * 双向链表中删除 node 节点
     *
     * @param node
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }


    private static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }


}
