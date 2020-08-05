package site.interview.rupeek;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

//https://www.geeksforgeeks.org/sum-of-all-even-occurring-element-in-an-array/#:~:text=Input%20%3A%20arr%5B%5D%20%3D%20%7B1,Sum%20%3D%2040.
public class SumOfEvenOccurringElementInanArray {

    public static int element(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (map.get(arr[i]) != null) {
                count = map.get(arr[i]);
            }
            map.put(arr[i], count + 1);
        }
        int sum = 0;
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                sum += entry.getKey() * entry.getValue();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3, 3, 3};
        // sum should be = 1+1+2+2=6;
        int n = arr.length;
        System.out.println(element(arr, n));
    }
}
