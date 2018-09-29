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

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4

        cache.traversalLinkedList(cache.head);
        cache.traversalMap();
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void traversalLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public void traversalMap() {
        for (int key: map.keySet()) {
            System.out.println(key + ": (" + map.get(key).key + ", " + map.get(key).val +")");
        }
        System.out.println();
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
        Node newNode = new Node(key, value);

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            map.remove(key);
        } else {
            if (map.size() >= capacity) {
                Node nodeToRemove = tail.prev;
                remove(tail.prev);
                map.remove(nodeToRemove.key);
            }
        }

        add(newNode);
        map.put(key, newNode);
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
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.key = key;
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