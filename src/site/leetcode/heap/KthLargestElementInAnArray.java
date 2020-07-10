package site.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {

    //Time Complexity : O(nlogn)
    //kth largest element is the same as N - kth smallest element
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //The time complexity of adding an element in a heap of size k is O(logk),
    //and we do it N times that means O(Nlogk) is time complexity for the algorithm.
    //Space Complexity : O(k) to store the heap elements.
    public static int findKthLargest2(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }

    //Approach3
    class Solution {
        int[] nums;

        public void swap(int a, int b) {
            int tmp = this.nums[a];
            this.nums[a] = this.nums[b];
            this.nums[b] = tmp;
        }


        public int partition(int left, int right, int pivot_index) {
            int pivot = this.nums[pivot_index];
            // 1. move pivot to end
            swap(pivot_index, right);
            int store_index = left;
            // 2. move all smaller elements to the left
            for (int i = left; i <= right; i++) { // can run the loop till right -1 also,
                // as no comparison is done for i=right as pivot is at right only
                if (this.nums[i] < pivot) {
                    swap(store_index, i);
                    store_index++;
                }
            }
            // 3. move pivot to its final place
            swap(store_index, right);
            return store_index;
        }


//        Time complexity : O(N) in the average case,(N^2) in the worst case.
//        Space complexity : O(1)
        public int quickselect(int left, int right, int k_smallest) {
            if (left == right) // If the list contains only one element,
                return this.nums[left];  // return that element
            // select a random pivot_index
            Random random_num = new Random();
            int pivot_index = left + random_num.nextInt(right - left);
            pivot_index = partition(left, right, pivot_index);
            // the pivot is on (N - k)th smallest position
            if (k_smallest == pivot_index)
                return this.nums[k_smallest];
            else if (k_smallest < pivot_index)
                return quickselect(left, pivot_index - 1, k_smallest);
            return quickselect(pivot_index + 1, right, k_smallest);
        }

        public int findKthLargest(int[] nums, int k) {
            this.nums = nums;
            int size = nums.length;
            // kth largest is (N - k)th smallest
            return quickselect(0, size - 1, size - k);
        }
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
//        int[] arr2 = {3,2,3,1,2,4,5,5,6};
//        int kk = 4 ;
        int k = 2;
        //findKthLargest(arr,k);

    }
}
