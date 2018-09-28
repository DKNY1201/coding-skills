package leetcode.tree.SystemDesign;

import java.util.HashMap;

/**
 * Created by Bi on 9/27/18.
 */
class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key);

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(newNode);
            map.remove(key);
            map.put(key, newNode);
        } else {
            if (map.size() < capacity) {
                add(newNode);
                map.put(key, newNode);
            } else {
                remove(tail.prev);
                add(newNode);
                map.remove(key);
                map.put(key, newNode);
            }
        }
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void add(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
    }
}

class Node {
    int val;
    Node prev;
    Node next;
    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */