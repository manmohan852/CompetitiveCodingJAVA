package site.concurrency;
//https://leetcode.com/problems/the-dining-philosophers/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TheDiningPhilosphers {
}

class DiningPhilosophers {
    private static int NUMBER_OF_PHILOSOPHER = 5;
    private Lock[] forks = new Lock[5];

    public DiningPhilosophers() {
        //initialize lock
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        Lock leftFork = forks[philosopher % NUMBER_OF_PHILOSOPHER];
        Lock rightFork = forks[(philosopher + 1) % NUMBER_OF_PHILOSOPHER];

        leftFork.lock();
        rightFork.lock();

        try { //in case this philosopher drop dead at the table
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();

        } finally {
            leftFork.unlock();//has to be the same order as lock...
            rightFork.unlock();//to avoid deadlock..
        }
    }
}