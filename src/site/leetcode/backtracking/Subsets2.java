package site.leetcode.backtracking;

import java.util.*;

//https://leetcode.com/problems/subsets-ii/
public class Subsets2 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private static void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        if (start >= nums.length)
            return;

        for (int i = start; i < nums.length; i++) {
            // skip duplicate
            if (i != start && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            backtrack(nums, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int[] nums2 = new int[]{1, 2, 2};
        subsetsWithDup(nums2);
    }

}
