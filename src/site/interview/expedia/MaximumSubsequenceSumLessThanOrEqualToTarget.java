package site.interview.expedia;

import java.util.*;

public class MaximumSubsequenceSumLessThanOrEqualToTarget {

    //both solution gives TLE on hackerrank in expedia test, only 8/14 test cases paased.

    public static long maxSum(List<Long> arr, long threshold) {
        List<List<Long>> c = new ArrayList<>();
        List<Long> l;
        long max = 0l;
        try {
            for (int i = 0; i < arr.size(); i++) {
                int k = c.size();
                for (int j = 0; j < k; j++) {
                    l = new ArrayList<>(c.get(j));
                    l.add(arr.get(i));
                    long sum = getSum(l);
                    if (sum <= threshold) {
                        max = Math.max(sum, max);
                        c.add(l);
                    }
                }
                l = new ArrayList<>();
                l.add(arr.get(i));
                long sum = getSum(l);
                if (sum <= threshold) {
                    max = Math.max(sum, max);
                    c.add(l);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
        return max;
    }

    public static long getSum(List<Long> lis) {
        long sum = 0;
        for (int i = 0; i < lis.size(); i++) {
            sum += lis.get(i);
        }
        return sum;
    }

    public static long maxSum2(List<Long> arr, long threshold) {
        List<Long> c = new ArrayList<>();
        long max = 0l;
        for (int i = 0; i < arr.size(); i++) {
            int k = c.size();
            if (arr.get(i) > threshold) continue;
            for (int j = 0; j < k; j++) {
                long currentSum = c.get(j);
                currentSum = currentSum + arr.get(i);
                if (currentSum == threshold) {
                    max = Math.max(currentSum, max);
                    return max;
                }
                if (currentSum < threshold) {
                    max = Math.max(currentSum, max);
                    c.add(currentSum);
                }
            }
            if (arr.get(i) <= threshold) {
                max = Math.max(arr.get(i), max);
                c.add(arr.get(i));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Long[] arr = {20l,
                37444l,
                8l,
                290l,
                33l,
                29326611669356007l,
                53601728509869363l,
                1167l,
                69619977749241889l,
                9360l,
                4678l,
                6507866325965366l,
                16l,
                143l,
                70l,
                2l,
                2337l,
                52091561299545338l,
                582l,
                18720l,
                41446282200229782l};
        List<Long> arr2 = new ArrayList<>(Arrays.asList(arr));

        long target = 465406133020727846l;
        if (maxSum(arr2, target) == maxSum2(arr2, target)) {
            System.out.println();
            System.out.println("ksdfkjbsg");
        }
        maxSum2(arr2, target);
    }
}
