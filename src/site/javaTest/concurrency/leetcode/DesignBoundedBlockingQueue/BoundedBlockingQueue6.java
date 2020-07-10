package site.javaTest.concurrency.leetcode.DesignBoundedBlockingQueue;

import java.util.ArrayDeque;

public class BoundedBlockingQueue6 {

    ArrayDeque<Integer> deque;
    int cap;

    public BoundedBlockingQueue6(int capacity) {
        deque = new ArrayDeque<>(capacity);
        cap = capacity;
    }

    public synchronized void enqueue(int element) throws InterruptedException {
        while (deque.size() == cap) {
            wait();
        }
        deque.offerFirst(element);
        notifyAll();
    }

    public synchronized int dequeue() throws InterruptedException {
        while (deque.isEmpty()) {
            wait();
        }
        int last = deque.pollLast();
        notifyAll();
        return last;
    }

    public int size() {
        return deque.size();
    }
}
