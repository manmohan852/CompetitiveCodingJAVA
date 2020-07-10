package site.javaTest.concurrency.leetcode.DesignBoundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue5 {

    Semaphore sem;
    Queue<Integer> q;
    int sz;
    int cap = 0;
    public BoundedBlockingQueue5(int capacity) {
        q = new LinkedList<>();
        sem = new Semaphore(1);
        sz = 0;
        cap = capacity;
    }

    public synchronized void enqueue(int element) throws InterruptedException {
        while(sz >= cap){
            wait();
        }
        sem.acquire();
        q.offer(element);
        sem.release();
        sz++;
        notifyAll();
    }

    public synchronized int dequeue() throws InterruptedException {
        while(sz <= 0){
            wait();
        }
        sem.acquire();
        int val = q.poll();
        sem.release();
        sz--;
        notifyAll();
        return val;
    }

    public int size() {
        return sz;
    }
}
