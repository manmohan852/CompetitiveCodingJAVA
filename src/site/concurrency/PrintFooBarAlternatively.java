package site.concurrency;
//https://leetcode.com/problems/print-foobar-alternately/
//http://mlixin.com/2019/10/31/leetcode-1115/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintFooBarAlternatively {
    private int n;

    Lock lock = new ReentrantLock();
    boolean printFooFlag = true;

    public PrintFooBarAlternatively(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock) {
                while (!printFooFlag) {
                    lock.wait();
                }

                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                printFooFlag = false;
                lock.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock) {
                while (printFooFlag) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                printFooFlag = true;
                lock.notifyAll();
            }

        }
    }
}