package site.gfg.heap;

import java.util.*;

public class TopKFrequentElements {

    static class EFreq {
        Integer ele;
        Integer freq;

        public EFreq(Integer ele, Integer freq) {
            this.ele = ele;
            this.freq = freq;
        }
    }


    //Time complexity : O(NlogN)
    //Space complexity : O(N)
    public static int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k];
        List<EFreq> freqList = new ArrayList<>();
        int count = 1;
        int i;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]){
                count++;
            }
            else{
                freqList.add(new EFreq(nums[i-1],count));
                count = 1;
            }
        }
        freqList.add(new EFreq(nums[i-1],count));
        freqList.sort(new Comparator<EFreq>() {
            @Override
            public int compare(EFreq t1, EFreq t2) {
                return t2.freq.compareTo(t1.freq);
            }
        });
        for (i = 0;i<k;i++){
            res[i] = freqList.get(i).ele;
        }
        return res;
    }

    //Time complexity : O(Nlogk) if k<N and O(N) in the particular case of N=k.
    // That ensures time complexity to be better than O(NlogN).
    //Space complexity : O(N+k) to store the hash map with not more N elements and a heap with k elements.
    public static int[] topKFrequent2(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        //Min heap
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3,7,7,7,7,7,8,9,9};
        int k = 2;
        topKFrequent(nums, k);
    }
}
