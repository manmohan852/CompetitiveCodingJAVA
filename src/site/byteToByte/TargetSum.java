package site.byteToByte;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    // Naive brute force solution. Find every combinations
//    The recursive tree branches by 2 each time, which yields a runtime of 2 * 2 * …* 2 or O(2^n),
//    where n is the number of numbers. Our space complexity is the depth of the recursion. In this case, it is the
//    length of our input, or O(n).
    public int targetSum(int[] nums, int T) {
        return targetSum(nums, T, 0, 0);
    }

    // Overloaded recursive function
    private int targetSum(int[] nums, int T, int i, int sum) {
        // When we've gone through every item, see
        // if we've reached our target sum
        if (i == nums.length) {
            return sum == T ? 1 : 0;
        }
        // Combine the possibilites by adding and
        // subtracting the current value
        return targetSum(nums, T, i + 1, sum + nums[i])
                + targetSum(nums, T, i + 1, sum - nums[i]);
    }

    //Method2:

    // Top down dynamic programming solution. Like
// 0-1 Knapsack, we use a HashMap to save
// space
    public int targetSum2(int[] nums, int T) {
        // Map: i -> sum -> value
        Map<Integer, Map<Integer, Integer>> cache =
                new HashMap<>();
        return targetSum2(nums, T, 0, 0, cache);
    }

    // Overloaded recursive function
    private int targetSum2(
            int[] nums, int T, int i, int sum,
            Map<Integer, Map<Integer, Integer>> cache) {
        if (i == nums.length) {
            return sum == T ? 1 : 0;
        }

        // Check the cache and return if we get a
        // hit
        if (!cache.containsKey(i)) cache.put(i,
                new HashMap<Integer, Integer>());
        Integer cached = cache.get(i).get(sum);
        if (cached != null) return cached;

        // If we didn't hit in the cache, compute the value and store to cache
        int toReturn = targetSum2(nums, T, i + 1, sum + nums[i], cache) +
                        targetSum2(nums, T, i + 1, sum - nums[i], cache);
        cache.get(i).put(sum, toReturn);
        return toReturn;
    }

//    In order to get the space complexity, we need to determine the
//    range of the sum. This is because we are caching solutions for
//    subproblems based on i and sum. An examination of our code
//    shows that the sum ranges from -sum(nums) (if every value is
//    subtracted) to +sum(nums) (if every value is added). This yields
//    a space complexity of O(i * sum(nums)). The time complexity
//    is exactly the same, since we only have to compute each value
//    once.

}
