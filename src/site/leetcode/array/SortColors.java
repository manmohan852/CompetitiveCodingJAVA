package site.leetcode.array;
//https://leetcode.com/problems/sort-colors/
public class SortColors {

    //O(n)
    public static void sortColors(int[] nums) {
        int red = 0;
        int blue = nums.length - 1;
        int i = red;
        while (red < blue && i <= blue) {
            if (nums[red] == 0) {
                red++;
                if (i < red) {
                    i = red;
                }
                continue;
            }
            if (nums[blue] == 2) {
                blue--;
                continue;
            }
            if (nums[i] == 2) {
                swap(nums, i, blue);
            } else if (nums[i] == 0) {
                swap(nums, red, i);
            } else {
                i++;
            }
        }
    }

    ////O(n^2)
    public static void sortColors2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {1, 2, 1};
        sortColors(nums2);
    }
}
