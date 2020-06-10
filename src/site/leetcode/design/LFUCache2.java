package site.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache2 {

    private Map<Integer, Node> map;
    private PriorityQueue<Node> pq;
    private int cap;
    private static int timer;

    public LFUCache2(int capacity) {
        map = new HashMap<>();
        pq = new PriorityQueue<Node>(
                (a, b)->(a.count==b.count?(a.timer-b.timer):(a.count-b.count))); // element at head will have least count and oldest
        cap = capacity;
        timer = 0;
    }

    private void remove(Node node) {
        map.remove(node.key);
        pq.remove(node);
    }

    private void add(Node node) {
        map.put(node.key, node);
        pq.offer(node);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(new Node(node.key, node.val, node.count+1, timer++));
            return node.val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(new Node(key, value, node.count+1, timer++));
        } else {
            if (cap!=0) {
                if (map.size()==cap) remove(pq.peek());//element from head is removed
                add(new Node(key, value, 1, timer++));
            }
        }
    }

    class Node {
        int key;
        int val;
        int count;
        int timer;
        public Node(int k, int v, int c, int t) {
            this.key = k;
            this.val = v;
            this.count = c;
            this.timer = t;
        }
    }
}

