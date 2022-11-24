package site.javaTest.concurrency.leetcode.DesignBoundedBlockingQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue4 {

    Lock lock;
    Condition notFull;
    Condition notEmpty;
    Deque<Integer> queue;
    int cap;

    public BoundedBlockingQueue4(int capacity) {
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
        queue = new LinkedList<>();
        cap = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() >= cap) {
                notFull.await();
            }
            queue.addFirst(element);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }
            int val = queue.removeLast();
            notFull.signal();
            return val;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }


}
