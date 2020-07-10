package site.gfg.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeMap;
//https://leetcode.com/problems/sliding-window-maximum/
//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/?ref=rp
public class SlidingWindowMaximum {

    //Decreasing Monotonic Queue
    //Time: O(N)
    //Space: O(K)
    public static int[] maxSlidingWindow1(int[] arr, int k) {
        int n = arr.length, j = 0;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) { // If arr[i] >= deque.peekLast() -> Can discard the tail since it's useless
                deque.pollLast();
            }
            deque.addLast(i);
            if (i + 1 >= k) {
                ans[j++] = arr[deque.peekFirst()];
            }
            if (i - deque.peekFirst() + 1 >= k) { // remove the last element of range k
                deque.removeFirst();
            }
        }
        return ans;
    }

    //MAX_HEAP
    //Time: O(NlogN), each operation of maxHeap of size N costs O(logN)
    //Space: O(N)
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length, j = 0;
        int[] ans = new int[n - k + 1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            maxHeap.add(new int[]{arr[i], i});
            if (i + 1 >= k) {
                ans[j++] = maxHeap.peek()[0];
            }
            while (maxHeap.size() > 0 && i - maxHeap.peek()[1] + 1 >= k) { // discard max elements of heap that out of range k
                maxHeap.poll();
            }
        }
        return ans;
    }

    //Binary Search Tree - TreeMap
    //Time: O(NlogK), each operation of BST of size K costs O(logK)
    //Space: O(K)
    public int[] maxSlidingWindow2(int[] arr, int k) {
        int n = arr.length, j = 0;
        int[] ans = new int[n - k + 1];
        TreeMap<Integer, Integer> bst = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            bst.put(arr[i], bst.getOrDefault(arr[i], 0) + 1);
            if (i + 1 >= k) {
                ans[j++] = bst.lastKey(); // return max element in BST
                removeElement(bst, arr[i+1-k]);
            }
        }
        return ans;
    }
    void removeElement(TreeMap<Integer, Integer> bst, int x) {
        bst.put(x, bst.getOrDefault(x, 0) - 1);
        if (bst.get(x) == 0) bst.remove(x);
    }



    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        maxSlidingWindow1(arr, k);
    }
}
