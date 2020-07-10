package site.byteToByte;

import java.util.PriorityQueue;

//K-WayMerge: Used in External Merge Sort
public class MergeKArrays {

    private static class QueueNode implements Comparable<QueueNode> {
        int array, index, value;


        public QueueNode(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }

        //increasing order compareTO
        public int compareTo(QueueNode n) {
            if (value > n.value) return 1;
            if (value < n.value) return -1;
            return 0;
        }
    }

    public static int[] merge(int[][] arrays) {
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();

        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            size += arrays[i].length;
            if (arrays[i].length > 0) {
                QueueNode queueNode = new QueueNode(i,0,arrays[i][0]);
                pq.add(queueNode);
            }
        }

        int[] result = new int[size];
        for (int i = 0; !pq.isEmpty(); i++) {
            QueueNode n = pq.poll();
            result[i] = n.value;
            int newIndex = n.index + 1;
            if (newIndex < arrays[n.array].length) {
                QueueNode queueNode = new QueueNode(n.array,newIndex,arrays[n.array][newIndex]);
                pq.add(queueNode);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 4;  //no of element in each sorted array
        int K = 5; //no of sorted arrays
        int[][] arrays = new int[K][N];
        arrays[0] = new int[]{2, 4, 6, 19};
        arrays[1] = new int[]{1, 20, 35, 67};
        arrays[2] = new int[]{3, 5, 7, 11};
        arrays[3] = new int[]{45, 46, 47, 48};
        arrays[4] = new int[]{3, 9, 100, 200};
        merge(arrays);

    }
}
