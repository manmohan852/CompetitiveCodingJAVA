package site.interview.amazon;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/first-unique-number/
public class FirstUniqueNumber {

    private Queue<Integer> queue = new ArrayDeque<>();
    private Map<Integer, Boolean> isUnique = new HashMap<>();

    public FirstUniqueNumber(int[] nums) {
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && !isUnique.get(queue.peek())) {
            queue.remove();
        }
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        return -1;
    }

    public void add(int value) {
        if (!isUnique.containsKey(value)) {
            isUnique.put(value, true);
            queue.add(value);
        } else {
            isUnique.put(value, false);
        }
    }
}