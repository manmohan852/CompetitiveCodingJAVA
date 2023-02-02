package MySite.LeetCode.TwoPointers;
// https://leetcode.com/problems/trapping-rain-water/description/
public class trappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = trap(height);
        System.out.println(ans);
    }
    public static int trap(int[] height) {
        int n = height.length;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(height[max] <  height[i]){
                max = i;
            }

        }
        int leftmax = 0;
        int sum = 0;
        for(int i = 0; i < max; i++){
            if(height[leftmax] < height[i]){
                leftmax = i;
            }
            sum += Math.min(height[leftmax] , height[max]) - height[i];
        }
        int rightmax = n - 1;
        for(int i = n - 1; i > max; i--){
            if(height[rightmax] < height[i]){
                rightmax = i;
            }
            sum += Math.min(height[rightmax] , height[max]) - height[i];
        }
        return sum;
    }
}
