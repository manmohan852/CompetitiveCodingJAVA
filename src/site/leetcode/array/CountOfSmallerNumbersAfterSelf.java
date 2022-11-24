package site.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
//315. Count of Smaller Numbers After Self
public class CountOfSmallerNumbersAfterSelf {

    public static List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

    private static int findIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < target) return end + 1;
        if (sorted.get(start) >= target) return 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= target) return start;
        return end;
    }

    public static List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    public static int insertNode(TreeNode root, int val) {
        int thisCount = 0;
        while (true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                thisCount += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return thisCount;
    }

    public static void main(String[] args) {
        int[] lis = {5, 2, 3, 6, 1};
        countSmaller(lis);
        countSmaller2(lis);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int count = 1;

    public TreeNode(int val) {
        this.val = val;
    }
}