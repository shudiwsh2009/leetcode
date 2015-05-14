package com.ise.shudi.leetcode.sort146.lru.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    
    private Node head = null, tail = null;
    private Map<Integer, Node> map = null;
    private int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node cur = map.get(key);
            if(cur != head && cur != tail) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur.prev = null;
                cur.next = head;
                head.prev = cur;
                head = cur;
            } else if(cur == head) {
                
            } else if(cur == tail) {
                cur.prev.next = null;
                cur.prev = null;
                cur.next = head;
                head.prev = cur;
                head = cur;
            }
            return cur.val;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(get(key) != -1) {
            head.val = value;
            return;
        }
        if(map.size() == capacity) {
            map.remove(tail.key);
            if(head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        }
        Node cur = new Node(key, value);
        map.put(key, cur);
        if(head == null) {
            head = tail = cur;
        } else {
            cur.next = head;
            head.prev = cur;
            head = cur;
        }
    }
    
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache(2);
    	cache.set(2, 1);
    	cache.set(1, 1);
    	cache.get(2);
    	cache.set(4, 1);
    	cache.get(1);
    	cache.get(2);
    }
    
}

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    
    public Node(int k, int v) {
        key = k;
        val = v;
    }
}
