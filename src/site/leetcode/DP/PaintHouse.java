package site.leetcode.DP;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/paint-house/
public class PaintHouse {

    private static int[][] costs;

    //Time complexity : O(2^n)
    public static int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        costs = costs;
        return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
    }

    private static int paintCost(int n, int color) {
        int totalCost = costs[n][color];
        if (n == costs.length - 1) {
        } else if (color == 0) { // Red
            totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
        } else if (color == 1) { // Green
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
        } else { // Blue
            totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
        }
        return totalCost;
    }


    //Time complexity : O(n)
    static class Solution {

        private int[][] costs;
        private Map<String, Integer> memo;

        public int minCost(int[][] costs) {
            if (costs.length == 0) {
                return 0;
            }
            this.costs = costs;
            this.memo = new HashMap<>();
            return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
        }

        private int paintCost(int n, int color) {
            if (memo.containsKey(getKey(n, color))) {
                return memo.get(getKey(n, color));
            }
            int totalCost = costs[n][color];
            if (n == costs.length - 1) {
            } else if (color == 0) { // Red
                totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
            } else if (color == 1) { // Green
                totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
            } else { // Blue
                totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
            }
            memo.put(getKey(n, color), totalCost);
            return totalCost;
        }

        private String getKey(int n, int color) {
            return String.valueOf(n) + " " + String.valueOf(color);
        }
    }

    public static void main(String[] args) {
        int[][] costs  = {{17,2,17},{16,16,5},{14,3,19}};
        Solution solution = new Solution();
        solution.minCost(costs);
        System.out.println();
    }
}
