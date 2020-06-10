package site.gfg.graph;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
public class MinimumNoOfPlatformsRequired {

    //Time Complexity: O(n^2).
    static int findPlatform(int arr[], int dep[], int n) {
        int plat_needed = 1, result = 1;
        for (int i = 0; i < n; i++) {
            plat_needed = 1;
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i]))
                    plat_needed++;
            }
            result = Math.max(result, plat_needed);
        }
        return result;
    }

    //Time Complexity: O(n)
    static int findPlatform2(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }
            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }
            if (plat_needed > result)
                result = plat_needed;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        findPlatform(arr, dep, arr.length);
    }
}
