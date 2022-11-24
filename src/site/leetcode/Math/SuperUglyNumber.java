package site.leetcode.Math;

import java.util.PriorityQueue;

//https://leetcode.com/problems/super-ugly-number/
public class SuperUglyNumber {

    //MinHeapPriorityQueue
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        int count = 1; // count for 1 as the first element
        long num = 1;
        for (int i : primes) {
            q.add((long) i); //adding for all primes multiplied by 1
        }
        while (count < n) {
            num = q.poll();
            if (q.isEmpty() || num != q.peek()) {
                count++;
                for (int i : primes) {
                    q.add(num * i);
                }
            }
        }
        return (int) num;
    }

    public static void main(String[] args) {
        int[] primes = {5,7,13};
        nthSuperUglyNumber(8,primes);
    }
}
