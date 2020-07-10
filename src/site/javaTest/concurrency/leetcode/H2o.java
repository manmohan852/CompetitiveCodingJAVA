package site.javaTest.concurrency.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
//https://leetcode.com/problems/building-h2o/
class H2o {
    private final AtomicInteger h2o = new AtomicInteger();

    public H2o() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (h2o) {
            // if already release two Hydrogen, wait for Oxygen release
            while (h2o.get() == 2) {
                h2o.wait();
            }
            h2o.addAndGet(1);
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h2o.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (h2o) {
            // if already release Oxygen, wait for Hydrogen release
            while (h2o.get() < 0) {
                h2o.wait();
            }
            h2o.addAndGet(-2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            h2o.notifyAll();
        }
    }
}