package site.interview.wheelsye;

import java.util.Arrays;

public class MaximumRailWaterBetweenTwoBuildings {

//    Time Complexity = O(n)
    public static int findWater2(int arr[], int n) {
        int result = 0;
        int left_max = 0, right_max = 0;
        int lo = 0, hi = n - 1;
        int[] sumArray = new int[n];
        Arrays.fill(sumArray,-1);
        int i = 0;
        while (lo <= hi) {
            if (arr[lo] < arr[hi]) {
                if (arr[lo] > left_max)
                    left_max = arr[lo];
                else {
                    sumArray[i] = left_max - arr[lo];
//                    result += left_max - arr[lo];
                }
                lo++;
            } else {
                if (arr[hi] > right_max)
                    right_max = arr[hi];
                else {
                    sumArray[i] = right_max - arr[hi];
//                    result += right_max - arr[hi];
                }
                hi--;
            }
            i++;
        }
        //result = total water which can be contained using all buildings. //TrappingRainWater.java for this solution
        int maxWaterBetweenTwoBuildings = 0;
        int sum = 0;
        for (int j = 0;j<n;j++){
            if(sumArray[j] != -1){
                sum += sumArray[j];
                maxWaterBetweenTwoBuildings = Math.max(maxWaterBetweenTwoBuildings,sum);
            }else{
                sum = 0;
            }
        }

        return maxWaterBetweenTwoBuildings;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        findWater2(arr, arr.length);
    }

}
