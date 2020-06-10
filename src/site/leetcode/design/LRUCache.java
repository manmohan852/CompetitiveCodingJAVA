package site.leetcode.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
//146. LRU Cache
public class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node() {
        }
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head, tail;
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else if (map.size() == capacity) {
            Node lastNode = tail.prev;
            removeNode(lastNode);
            map.remove(lastNode.key);
            Node newNode = new Node(key, value);
            insertToHead(newNode);
        } else {
            Node newNode = new Node(key, value);
            insertToHead(newNode);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        insertToHead(node);
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        map.put(node.key, node);
    }
}