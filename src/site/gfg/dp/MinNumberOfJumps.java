package site.gfg.dp;

//https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
public class MinNumberOfJumps {

    //Time Complexity: O(n) in worst case.
    static int minJumps(int arr[]) {
        if (arr.length <= 1)
            return 0;
        if (arr[0] == 0)
            return -1;
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                return jump;
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                jump++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
            }
        }
        return -1;
    }

    //Time Complexity: O(n^2)
    private static int minJumps(int[] arr, int n) {
        int jumps[] = new int[n];
        int i, j;
        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;
        jumps[0] = 0;
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }

    static int minJumps(int arr[], int l, int h) {
        if (h == l)
            return 0;
        if (arr[l] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumps(arr, i, h);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
                min = jumps + 1;
        }
        return min;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }
}
