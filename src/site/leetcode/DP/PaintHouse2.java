package site.leetcode.DP;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/paint-house-ii/
public class PaintHouse2 {

    private static int n;
    private static int k;
    private static int[][] costs;
    private static Map<String, Integer> memo;

    //Time complexity : O(n*k*k)
    //Space complexity : O(n*k)
    public static int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        k = costs[0].length;
        n = costs.length;
        costs = costs;
        memo = new HashMap<>();
        int minCost = Integer.MAX_VALUE;
        for (int color = 0; color < k; color++) {
            minCost = Math.min(minCost, memoSolve(0, color));
        }
        return minCost;
    }

    private static int memoSolve(int houseNumber, int color) {

        // Base case: There are no more houses after this one.
        if (houseNumber == n - 1) {
            return costs[houseNumber][color];
        }

        // Memoization lookup case: Have we already solved this subproblem?
        if (memo.containsKey(getKey(houseNumber, color))) {
            return memo.get(getKey(houseNumber, color));
        }

        // Recursive case: Determine the minimum cost for the remainder.
        int minRemainingCost = Integer.MAX_VALUE;
        for (int nextColor = 0; nextColor < k; nextColor++) {
            if (color == nextColor) continue;
            int currentRemainingCost = memoSolve(houseNumber + 1, nextColor);
            minRemainingCost = Math.min(currentRemainingCost, minRemainingCost);
        }
        int totalCost = costs[houseNumber][color] + minRemainingCost;
        memo.put(getKey(houseNumber, color), totalCost);
        return totalCost;
    }

    // Convert a house number and color into a simple string key for the memo.
    private static String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }


    //Time complexity : O(n*k*k)
//    Space complexity : O(1) if done in-place,
    public int minCostII2(int[][] costs) {

        if (costs.length == 0) return 0;
        int k = costs[0].length;
        int n = costs.length;

        for (int house = 1; house < n; house++) {
            for (int color = 0; color < k; color++) {
                int min = Integer.MAX_VALUE;
                for (int previousColor = 0; previousColor < k; previousColor++) {
                    if (color == previousColor) continue;
                    min = Math.min(min, costs[house - 1][previousColor]);
                }
                costs[house][color] += min;
            }
        }

        // Find the minimum in the last row.
        int min = Integer.MAX_VALUE;
        for (int c : costs[n - 1]) {
            min = Math.min(min, c);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] costs = {{1, 5, 3}, {2, 9, 4}};
        minCostII(costs);
        System.out.println();
    }
}
