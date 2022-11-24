package site.leetcode.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-cost-to-hire-k-workers/
//857. Minimum Cost to Hire K Workers
public class MinCostToHireKWorkers {
    public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if (K <= 0 || quality == null || quality.length == 0 || wage == null || wage.length == 0) return 0.0;
        int n = quality.length;
        if (wage.length != n) return 0;
        double[][] ratio = new double[n][2];
        for (int i = 0; i < n; i++) {
            ratio[i][0] = (double) wage[i] / quality[i];
            ratio[i][1] = (double) quality[i];
        }
        Arrays.sort(ratio, (a, b) -> Double.compare(a[0], b[0])); // Crucial
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0; // Quality sum
        double min = Double.MAX_VALUE;
        for (double[] e : ratio) {
            sum += e[1];
            maxHeap.offer(e[1]);

            if (maxHeap.size() > K) // Worker of highest quality is removed, because you need to pay him more with the same ratio
                sum -= maxHeap.poll();

            if (maxHeap.size() == K) // When exactly K, then calculate min. The idea is to hire workers at low ratio (i.e. K-th smallest ratio)
                min = Math.min(min, e[0] * sum);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] quality = {3, 1, 10, 10, 1};
        int[] wages = {4, 8, 2, 2, 7};
        int K = 3;
        mincostToHireWorkers(quality, wages, K);
    }
}
//wage is the salary per day for that worker
//quality is the total time units he works when he is hired.
// wage per time units = wage[i] / quality[i]
// Now, just sort all the workers by their hourly wage.
// To be fair you should be paying the top earner's wage to all the K workers.



//    This algorithm is pretty mind-fucking. I mean, to pay workers low, you need to figure out
//        that you need to sort the wage / quality ratio. And at k-th ratio you get basically
//        K workers who can be hired and whose min wage can be satisfied. However, you need to keep the cost minimum.
//        Hence, you calculate the cost whenever you accumulate K workers, and
//        when exceeds K workers, you eliminate the worker that gives highest quality,
//        as you have to pay him according to quality with the same ratio. So,
//        it's safe to remove him (that's what you do using PriorityQueue and adjust the total quality)
//        and choose higher wage/quality ratio to calculate the cost for the next K workers.
