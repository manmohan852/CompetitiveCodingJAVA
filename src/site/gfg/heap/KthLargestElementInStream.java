package site.gfg.heap;

import java.util.Scanner;

//T(n) == O(Logk)
public class KthLargestElementInStream {
    // question is aking about kth largest elment, not the max or largest elemnt,, so it means ,
    // there will always be k-1 items in the heap greater than this kth largest elemnt.

    public static void main(String[] args) {
        int k = 3;
        System.out.println(k);
        kthLargest(k);
    }

    private static void kthLargest(int k) {
        int count = 0;
        int x;
        int arr[] = new int[3];
        MinHeap minHeap = new MinHeap(arr, 3);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter next element of stream: ");
            x = scanner.nextInt();
            if (count < k - 1) {
                arr[count] = x;
                count++;
            } else {
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

        int extractMin() {
            if (heapSize <= 0)
                return Integer.MAX_VALUE;
            if (heapSize == 1) {
                heapSize--;
                return harr[0];
            }
            int root = harr[0];
            harr[0] = harr[heapSize - 1];
            heapSize--;
            MinHeapify(0);
            return root;
        }
    }
}
