package site.gfg.HEAP;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class KthLargestElementInStream {

    public static void main(String[] args) {
        int k = 3;
        System.out.println(k);
        kthLargest(k);
    }

    private static void kthLargest(int k) {
        int count = 0;
        int x;
        int arr[] = new int[3];
        MinHeap minHeap = new MinHeap(arr,3);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter next element of stream: ");
            x = scanner.nextInt();
             if(count < k-1){
                 arr[count] = x;
                 count ++;
             }
             else {
                 if (count == k - 1) {
                     arr[count] = x;
                     minHeap.buildHeap();
                 } else {
                     if (x > minHeap.getMin()) {
                         minHeap.replaceMin(x);
                     }
                 }
                 System.out.println("K'th largest element is:  " + minHeap.getMin());
                 count++;
             }
        }
    }

    static class MinHeap {
        int heapSize;
        int harr[];

        MinHeap(int arr[], int heapSize) {
            this.harr = arr;
            this.heapSize = heapSize;
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        int left(int i) {
            return (2 * i + 1);
        }

        int right(int i) {
            return (2 * i + 2);
        }

        int getMin() {
            return harr[0];
        }

        void replaceMin(int x) {
            harr[0] = x;
            MinHeapify(0);
        }

        public void buildHeap() {
            int i = (heapSize - 1) / 2;
            while (i >= 0) {
                MinHeapify(i);
                i--;
            }
        }

        public void MinHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < this.heapSize && harr[l] < harr[i])
                smallest = l;
            if (r < this.heapSize && harr[r] < harr[smallest])
                smallest = r;
            if (smallest != i) {
                int tmp = harr[i];
                harr[i] = harr[smallest];
                harr[smallest] = tmp;
                MinHeapify(smallest);
            }
        }
        public int extractMin() {
            if (heapSize == 0)
                return Integer.MAX_VALUE;
            int root = harr[0];
            if (heapSize > 1) {
                harr[0] = harr[heapSize - 1];
                MinHeapify(0);
            }
            heapSize--;

            return root;
        }
        Map<Integer,Integer> cache;
        public void  Solution(int capacity) {
            cache= new LinkedHashMap<>(capacity,0.75f,true){
                public boolean removeEldestEntry(Map.Entry eldest){
                    return size()>capacity;
                }
            };
        }

    }
}

