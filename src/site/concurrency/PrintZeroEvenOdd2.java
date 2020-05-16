package site.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;
////https://leetcode.com/problems/print-zero-even-odd/
public class PrintZeroEvenOdd2 {

    private int n;

    private Object lock = new Object();

    private ArrayBlockingQueue<Integer> zeroBlockingQueue = new ArrayBlockingQueue<>(1);

    private ArrayBlockingQueue<Integer> oddBlockingQueue = new ArrayBlockingQueue<>(1);


    public PrintZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (lock) {
                /**
                 * zero Blocking queue, 0 is blocking, 1 is not blocking:
                 * State 0: State 0 is non-blocking. Print 0 directly and become blocking after printing.
                 * State 1: Blocking, waiting to be awakened.
                 */
                while (zeroBlockingQueue.size() == 1) {
                    lock.wait();
                }
                zeroBlockingQueue.add(1);
                printNumber.accept(0);
                // System.out.print("0");
                lock.notifyAll();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                synchronized (lock) {
                    /**
                     * Prerequisite: Print 0 first, and wait if zero is not blocked
                     * odd Blocking queue, 0 is blocking, 1 is not blocking:
                     * State 0: No blocking, run directly, run into blocking
                     * State 1: Blocking, Waiting to Wake Up
                     */
                    while (oddBlockingQueue.size() == 1 || zeroBlockingQueue.size() == 0) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    //System.out.print(i);
                    //Clear 0 blocking queue
                    zeroBlockingQueue.clear();
                    oddBlockingQueue.add(1);
                    lock.notifyAll();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                synchronized (lock) {
                    /**
                     * Prerequisite: Print 0 first, and wait if zero is not blocked
                     * odd Blocking queue, 0 is blocking, 1 is not blocking:
                     * State 0: Blocking, because cardinality prints first
                     * State 1: Run. Clear two blocking queues after running and start a new round
                     */
                    while (oddBlockingQueue.size() == 0 || zeroBlockingQueue.size() == 0) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    // System.out.print(i);
                    zeroBlockingQueue.clear();
                    oddBlockingQueue.clear();
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);

        PrintZeroEvenOdd2 zeroEvenOdd = new PrintZeroEvenOdd2(5);

        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        countDownLatch.await();
    }
}