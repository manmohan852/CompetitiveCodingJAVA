package site.javaTest.concurrency.leetcode.DesignBoundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue2 {

    private Queue<Integer> queue;
    private int size;
    private Object lock;

    public BoundedBlockingQueue2(int capacity) {
        queue = new LinkedList<>();
        this.size = capacity;
        lock = new Object();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (lock) {
            while (queue.size() == size)
                lock.wait();// when queue is full wait
            queue.offer(element);
            lock.notify();
        }
    }

    public int dequeue() throws InterruptedException {
        int res = 0;
        synchronized (lock) {
            while (queue.size() == 0)
                lock.wait();
            res = queue.poll();
            lock.notify();
        }
        return res;
    }

    public int size() {
        return queue.size();
    }
}
