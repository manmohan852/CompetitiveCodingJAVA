package site.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
//https://leetcode.com/problems/fizz-buzz-multithreaded/
public class FizzBuzzMultiThreaded {
}

class FizzBuzz {
    private Semaphore fs, bs, fbs, ns;
    private int n;
    private int cur;

    public FizzBuzz(int n) {
        this.n = n;
        this.cur = 1;
        this.fs = new Semaphore(0, true);
        this.bs = new Semaphore(0, true);
        this.fbs = new Semaphore(0, true);
        this.ns = new Semaphore(1, true);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                this.fs.acquire();
                printFizz.run();
                this.cur++;
                this.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            if (i % 5 == 0 && i % 3 != 0) {
                this.bs.acquire();
                printBuzz.run();
                this.cur++;
                this.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            if (i % 15 == 0) {
                this.fbs.acquire();
                printFizzBuzz.run();
                this.cur++;
                this.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                this.ns.acquire();
                printNumber.accept(i);
                this.cur++;
                this.release();
            }
        }
    }

    public void release() {
        if (this.cur % 15 == 0) {
            this.fbs.release();
        } else {
            if (this.cur % 3 == 0) {
                this.fs.release();
            } else {
                if (this.cur % 5 == 0) {
                    this.bs.release();
                } else {
                    this.ns.release();
                }
            }
        }
    }
}