package site.gfg.heap;

import java.util.PriorityQueue;

//T(n) == nLog(n)
//time complexity for priority queue: add and poll, offer and remove method == O(logn)
//peek and elemnt method and contains === O(1)
//https://www.interviewsansar.com/what-is-time-complexity-for-offer-poll-and-peek-methods-in-priority-queue/
public class ConnectNRopes2 {

    static int minCost(int arr[], int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }
        int res = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            res += first + second;
            pq.add(first + second);
        }
        return res;
    }
}
