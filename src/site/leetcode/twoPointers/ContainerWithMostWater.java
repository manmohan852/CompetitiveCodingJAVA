package site.leetcode.twoPointers;
//https://leetcode.com/problems/container-with-most-water/
//https://www.geeksforgeeks.org/maximum-water-that-can-be-stored-between-two-buildings/?ref=rp
public class ContainerWithMostWater {//WaterTrappedBetweenTwoBuildings.java

    //Time complexity : O(n^2)
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    //Time complexity : O(n).
    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }


}
