package site.javaTest.concurrency.leetcode.DesignBoundedBlockingQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue7 {

    private final int capacity;
    private final Deque<Integer> q;
    private final Lock lock;
    private final Condition empty;
    private final Condition full;

    public BoundedBlockingQueue7(int capacity) {
        this.capacity = capacity;
        this.q= new ArrayDeque<>(capacity);
        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (q.size() >= capacity) {
                full.await();
            }
            q.offer(element);
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (q.size() <= 0) {
                empty.await();
            }
            int e = q.poll();
            full.signal();
            return e;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return q.size();
    }
}
