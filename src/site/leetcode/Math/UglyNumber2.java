package site.leetcode.Math;

import java.util.HashSet;
import java.util.PriorityQueue;
//https://leetcode.com/problems/ugly-number-ii/
public class UglyNumber2 {

    public int[] nums = new int[1690];

    UglyNumber2() {
        nums[0] = 1;
        int ugly, i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < 1690; ++i) {
            ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2) ++i2;
            if (ugly == nums[i3] * 3) ++i3;
            if (ugly == nums[i5] * 5) ++i5;
        }
    }

    //TimeComplexity O(1)
    public int nthUglyNumber(int n) {
        return this.nums[n - 1];
    }

    public static void main(String[] args) {
        UglyNumber2 uglyNumber2 = new UglyNumber2();
        uglyNumber2.nthUglyNumber(17);
    }
}

class Ugly {
    public int[] nums = new int[1690];
    Ugly() {
        HashSet<Long> seen = new HashSet();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.add(1L);

        long currUgly, newUgly;
        int[] primes = new int[]{2, 3, 5};
        for(int i = 0; i < 1690; ++i) {
            currUgly = heap.poll();
            nums[i] = (int)currUgly;
            for(int j : primes) {
                newUgly = currUgly * j;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }
            }
        }
    }
}

//Method2:
//TimeComplexity O(1)
class Solution {
    public static Ugly u = new Ugly();
    public int nthUglyNumber(int n) {
        return u.nums[n - 1];
    }
}