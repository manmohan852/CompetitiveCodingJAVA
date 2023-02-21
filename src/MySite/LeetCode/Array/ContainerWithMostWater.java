package MySite.LeetCode.Array;
// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {
        int n = height.length;
        int L = 0;
        int R = n - 1;
        int max = 0;
        while (L < R) {
            if (height[L] < height[R]) {
                max = Math.max(max, (R - L) * height[L]);
                L++;
            } else {
                max = Math.max(max, (R - L) * height[R]);
                R--;
            }

        }
        return max;
    }
}
