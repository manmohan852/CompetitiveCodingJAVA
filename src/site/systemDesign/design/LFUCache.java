package site.systemDesign.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lfu-cache/
//460. LFU Cache
public class LFUCache {
    int capacity;
    Map<Integer, Node> keyMap;
    Map<Integer, Node> countMap;
    DoublelyLinkedList list;

    LFUCache(int capacity) {
        this.capacity = capacity;
        keyMap = new HashMap<>();
        countMap = new HashMap<>();
        list = new DoublelyLinkedList();
        countMap.put(1, list.tailRef);
    }

    public int get(int key) {
        Node curr = keyMap.get(key);
        if (curr == null) {
            return -1;
        }
        this.put(curr.key, curr.val);
        return curr.val;
    }

    public void put(int key, int val) {
        if(capacity < 1) return;
        Node curr;
        Node targetNode;
        Node evictNode;

        if(keyMap.containsKey(key)) {
            evictNode = keyMap.get(key);
            targetNode = findNodeToInsertLeftOf(key);
            curr = new Node(key, val, evictNode.count + 1);
        }
        else {
            evictNode = (keyMap.size() == capacity) ? list.getTail() : null;
            targetNode = countMap.get(1);
            curr = new Node(key, val, 1);
        }

        countMap.put(curr.count, curr);
        keyMap.put(curr.key, curr);
        list.addLeftOfTarget(targetNode, curr);

        if(evictNode != null) {
            updateCountMapForEvicted(evictNode);//removed the previous count of that node,
            // since its count is now count+1, add any other other node whose count is same as this node
            list.removeNode(evictNode);
            if(evictNode.key != curr.key) keyMap.remove(evictNode.key);
        }
    }

    private void updateCountMapForEvicted(Node curr) {
        int count = curr.count;
        Node right = curr.next;
        if(countMap.get(count) == curr) {
            if(curr.count == right.count) countMap.put(count, right);
            else countMap.remove(count);
        }
    }

    private Node findNodeToInsertLeftOf(int key) {
        Node target = list.tailRef;
        if(keyMap.containsKey(key)) {
            Node curr = keyMap.get(key);
            int currCount = curr.count;
            target = countMap.getOrDefault(currCount+1, countMap.get(currCount));
        }
        return target;
    }
}

class DoublelyLinkedList {
    Node headRef;
    Node tailRef;

    DoublelyLinkedList() {
        headRef = new Node(-1, -1, 1);
        tailRef = new Node(-1, -1, 1);
        headRef.next = tailRef;
        tailRef.prev = headRef;
    }

    void addLeftOfTarget(Node target, Node curr) {
        Node left = target.prev;
        target.prev = curr;
        curr.next = target;
        curr.prev = left;
        left.next = curr;
    }

    void removeNode(Node curr) {
        Node left = curr.prev;
        Node right = curr.next;
        right.prev = left;
        left.next = right;
    }

    Node getTail() {
        return tailRef.prev;
    }
}

class Node {
    int val;
    int key;
    int count;
    Node prev;
    Node next;

    Node(int key, int val, int count) {
        this.val = val;
        this.key = key;
        this.count = count;
    }
}
