package site.javaTest.concurrency.leetcode;
//https://leetcode.com/problems/print-in-order/
//https://hezhigang.github.io/2019/08/08/LeetCode-Concurrency-Print-in-Order/
//https://github.com/varunu28/LeetCode-Java-Solutions/blob/master/Concurrency/Print%20in%20Order.java
public class PrintInOrder {
    private volatile int flag;

    public PrintInOrder() {
        flag = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        for (; ; ) {
            if (flag == 1) {
                printFirst.run();
                flag = 2;
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        for (; ; ) {
            if (flag == 2) {
                printSecond.run();
                flag = 3;
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        for (; ; ) {
            if (flag == 3) {
                printThird.run();
                flag = 1;
                break;
            }
        }
    }
}
