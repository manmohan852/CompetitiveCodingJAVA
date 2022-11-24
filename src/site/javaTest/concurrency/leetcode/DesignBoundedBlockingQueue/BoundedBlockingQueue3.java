package site.javaTest.concurrency.leetcode.DesignBoundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue3 {

    private Queue<Integer> queue;
    private int size;
    private Lock lock;
    private Condition condition;

    public BoundedBlockingQueue3(int capacity) {
        queue = new LinkedList<>();
        this.size = capacity;
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == size)
                condition.await();
            queue.offer(element);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        int res = 0;
        try {
            while (queue.size() == 0)
                condition.await(); // when queue size is 0 wait
            res = queue.poll();
            condition.signal();
        } finally {
            lock.unlock();
        }
        return res;
    }

    public int size() {
        return queue.size();
    }

}
