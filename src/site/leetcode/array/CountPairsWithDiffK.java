package site.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountPairsWithDiffK {

    static int binarySearch(int arr[], int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (x == arr[mid])
                return mid;
            if (x > arr[mid])
                return binarySearch(arr, (mid + 1),
                        high, x);
            else
                return binarySearch(arr, low,
                        (mid - 1), x);
        }
        return -1;
    }
    static int countPairsWithDiffK(int arr[], int n, int k) {
        int count = 0, i;
        Arrays.sort(arr);
        for (i = 0; i < n - 1; i++)
            if (binarySearch(arr, i + 1, n - 1,
                    arr[i] + k) != -1)
                count++;

        return count;
    }

    public static int countPairs(List<Integer> arr, int k) {
        int n = arr.size();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = arr.get(i);
        }
        int count = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < n - 1; i++) {
            if (binarySearch(numbers, i + 1, n - 1, numbers[i] + k) != -1) {
                count++;
            }
        }
        return count;
    }


    public static void main(String args[]) {
        int arr[] = {6,1,1,2,2,3,3,1};
        int n = arr.length;
        int k = 3;
        System.out.println("Count of pairs with given diff is "
                + countPairsWithDiffK(arr, n, k));

        List<Integer> arr2= new ArrayList<>(Arrays.asList(6,1,1,2,2,3,3,1));
        countPairs(arr2,3);
    }
}

