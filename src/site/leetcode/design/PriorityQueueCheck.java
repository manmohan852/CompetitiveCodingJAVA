package site.leetcode.design;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueCheck {
    public static void main(String args[]) {
        // Creating an empty PriorityQueue
        PriorityQueue<Integer> queue = new PriorityQueue<>(new IntegerComparator());

        // Use add() method to add elements into the Queue
        queue.add(10);
        queue.add(30);
        queue.add(15);
        queue.add(5);
        queue.add(20);
//        System.out.println(queue.size());//
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }


        // Displaying the PriorityQueue
        System.out.println("Initial PriorityQueue: " + queue);
//
//        // Removing elements using remove() method
//        queue.remove(30);
//        queue.remove(5);
//
//        // Displaying the PriorityQueue after removal
//        System.out.println("PriorityQueue after removing "
//                + "elements: " + queue);
    }

    static class IntegerComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return i1-i2;
        }
    }

    static class DescendingIntegerComparator implements Comparator<Integer> {
        public int compare(Integer i1, Integer i2) {
            return i2-i1;
        }
    }
}
