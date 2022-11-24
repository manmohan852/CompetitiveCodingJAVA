package site.javaTest.concurrency.leetcode.DesignBoundedBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class BoundedBlockingQueue1 {

    Object dummy = new Object();
    int capacity = 0;
    List<Integer> list = new LinkedList<>();

    public BoundedBlockingQueue1(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {

        synchronized (dummy) {
            while (list.size() == capacity) {
                dummy.wait();
            }

            list.add(element);
            dummy.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (dummy) {
            while (list.size() == 0) {
                dummy.wait();
            }

            int ele = list.remove(0);
            dummy.notifyAll();
            return ele;
        }
    }

    public int size() {
        return list.size();
    }
}
